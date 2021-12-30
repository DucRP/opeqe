package io.phoenix.businessmessenger.common.sdkextentions.extensions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Timber.e(throwable)
}

fun CoroutineScope.safeLaunch(
    exceptionHandler: CoroutineExceptionHandler = coroutineExceptionHandler,
    launchBody: suspend () -> Unit
): Job {
    return this.launch(exceptionHandler) {
        launchBody.invoke()
    }
}