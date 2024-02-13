package common

import de.jensklingenberg.ktorfit.Response

interface ApiHandler {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): Outcome<T> {
        return try {
            val response = execute()
            if (response.isSuccessful) {
                Success(response.body()!!)
            } else {
                Failure(response.message)
            }
        } catch (e: Exception) {
            Failure(e.message.orEmpty())
        } catch (e: Throwable) {
            Failure(errorResponse = e.stackTraceToString() ,throwable = e)
        }
    }
}