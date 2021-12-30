package io.phoenix.businessmessenger.common.networking

import io.phoenix.businessmessenger.data.entity.ServerException
import retrofit2.HttpException
import retrofit2.Response

@Throws(ServerException::class)
fun <T> Response<T>.bodyOrThrow(): T {
    if (!isSuccessful) throw HttpException(this)
    return body()!!
}

suspend inline fun <R> networkWithCache(
    crossinline createCall: suspend () -> R,
    crossinline loadFromLocal: suspend () -> R?,
    crossinline shouldFetch: suspend (R?) -> Boolean,
    crossinline saveCallResult: suspend (R) -> Unit
): R {
    val cache = loadFromLocal()
    val shouldFetchFromDb = shouldFetch(cache)

    return if (cache == null || shouldFetchFromDb) {
        val result = createCall()
        saveCallResult(result)
        result
    } else {
        cache
    }
}

suspend inline fun <R> networkNoCache(
    crossinline createCall: suspend () -> R
): R {
    return createCall()
}
