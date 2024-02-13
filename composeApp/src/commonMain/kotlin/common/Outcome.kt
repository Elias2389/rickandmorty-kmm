package common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed class Outcome<out T> {
    fun <R> mapSuccess(transform: (T) -> R): Outcome<R> {
        return when (this) {
            is Success -> Success(transform(response))
            is Failure -> this
        }
    }
}

open class Success<out T>(val response: T) : Outcome<T>() {
    operator fun invoke(): T = response

    override fun equals(other: Any?): Boolean {
        return (other as? Success<*>)?.response?.equals(this.response) == true
    }

    override fun hashCode(): Int {
        return response?.hashCode() ?: 0
    }
}


data class Failure(
    val errorResponse: String,
    val throwable: Throwable? = null
) : Outcome<Nothing>()


inline fun <T, reified R> Flow<Outcome<T>>.mapSuccess(
    crossinline onSuccess: (T) -> R
): Flow<Outcome<R>> = this
    .map {
        when (it) {
            is Success -> Success(onSuccess(it()))
            is Failure -> it
        }
    }

