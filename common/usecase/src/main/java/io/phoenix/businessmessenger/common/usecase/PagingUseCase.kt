package io.phoenix.businessmessenger.common.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

// todo fix error handling
abstract class PagingUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): Flow<R> {
        return withContext(coroutineDispatcher) {
            execute(parameters).flowOn(coroutineDispatcher)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): Flow<R>
}
