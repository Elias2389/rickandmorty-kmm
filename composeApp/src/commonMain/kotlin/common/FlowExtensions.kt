package common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingCommand
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

fun <T> Flow<Outcome<T>>.onException(message: String = "") =
    this.catch {
        emit(Failure(errorResponse = it.message ?: message, throwable = it))
    }


interface Refreshable {
    val refreshFlow: Flow<Unit>

    fun refresh()
}

class DefaultRefreshable : Refreshable {

    private val channel = Channel<Unit>()

    override val refreshFlow: Flow<Unit> = channel.receiveAsFlow()

    override fun refresh() {
        channel.trySend(Unit)
    }
}

/*
 * A sharing strategy that will clear the cache and restart the subscription when a given [Flow] emits
 * the sharingStarted passed in will dictate how this strategy starts sharing
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class SharingStartedUntil(
    private val sharingStarted: SharingStarted,
    private val flow: Flow<Unit>
) : SharingStarted {
    override fun command(subscriptionCount: StateFlow<Int>): Flow<SharingCommand> = merge(
        sharingStarted.command(subscriptionCount),
        flow.flatMapLatest {
            flowOf(
                SharingCommand.STOP_AND_RESET_REPLAY_CACHE,
                SharingCommand.START
            )
        }
    )
}

@Suppress("FunctionNaming")
fun SharingStartedLazilyUntil(
    flow: Flow<Unit>
) = SharingStartedUntil(
    sharingStarted = SharingStarted.Lazily,
    flow = flow
)


fun <T> Flow<Outcome<T>>.refreshStateIn(
    scope: CoroutineScope,
    refreshWhen: Flow<Unit>,
    sharingStarted: SharingStarted = SharingStartedLazilyUntil(refreshWhen)
): StateFlow<State<T>> = this.map {
    when (it) {
        is Failure -> State.Failed(null, it.throwable)
        is Success -> State.Loaded(it())
    }
}.stateIn(scope, sharingStarted, State.Loading())