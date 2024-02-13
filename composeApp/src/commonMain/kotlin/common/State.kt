package common


sealed class State<T> {
    class Loading<T> : State<T>()
    data class Loaded<T>(val data: T) : State<T>()
    data class Failed<T>(
        private val errorStringRes: Int?,
        val throwable: Throwable? = null,
    ) : State<T>()
}

