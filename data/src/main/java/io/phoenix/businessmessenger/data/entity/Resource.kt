package io.phoenix.businessmessenger.data.entity


import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.Resource.*


sealed class Resource<out R> {

    object None : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: Exception) : Resource<Nothing>()
    data class Loading(val loading: Boolean) : Resource<Nothing>()
    object Canceled : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is Loading -> "Loading"
            Canceled -> "Canceled"
            None -> "None"
        }
    }

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error
    fun isCanceled() = this is Canceled
}


inline fun <R> Resource<R>.onLoading(action: (Boolean) -> Unit): Resource<R> {
    if (this is Loading) {
        action(true)
    } else if (this !is Nothing) action(false)
    return this
}

inline fun <T> Resource<T>.onError(onFailure: (Exception) -> Unit) {
    if (this is Error) onFailure(error)
}

inline fun <R> Resource<R>.onSuccess(action: (R) -> Unit): Resource<R> {
    if (this is Success) {
        action(data)
    }
    return this
}

fun <R> Resource<R>.getDataOrException(): Success<R> {
    return (this as Success)
}

fun <T> Resource<T>.successOr(fallback: T): T {
    return (this as? Success<T>)?.data ?: fallback
}

suspend fun <T> Resource<T>.merge(action: suspend () -> Unit): Resource<T> {
    let {
        it.onSuccess {
            action.invoke()
        }
        it.onError { error ->
            throw error
        }
    }
    return this
}


fun <R, T> Resource<R>.map(mapper: Mapper<R, T>): Resource<T> {
    return when {
        this.isSuccess() -> {
            Success(mapper.map((this as Success).data))
        }
        this.isLoading() -> {
            Loading(this as Boolean)
        }
        this.isCanceled() -> {
            return Canceled
        }
        else -> {
            Error((this as Error).error)
        }
    }
}


