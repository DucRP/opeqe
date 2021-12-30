package io.phoenix.businessmessenger.common.usecase

import io.phoenix.businessmessenger.data.entity.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber


abstract class SuspendUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Resource<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Resource.Success(it)
                }
            }
        } catch (e: Exception) {
            Timber.d(e)
            Resource.Error(e)
        }
    }


    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
