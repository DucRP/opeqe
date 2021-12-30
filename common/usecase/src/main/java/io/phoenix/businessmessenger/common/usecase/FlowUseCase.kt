/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.phoenix.businessmessenger.common.usecase

import io.phoenix.businessmessenger.data.entity.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the Resource as
 * [Resource<R>].
 * Handling an exception (emit [Resource.Error] to the Resource) is the subclasses's responsibility.
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(parameters: P): Flow<Resource<R>> {
        try {
            return execute(parameters)
                .catch { e -> emit(Resource.Error(Exception(e))) }
                .flowOn(coroutineDispatcher)
        } catch (e: Exception) {
            return flow { Resource.Error(e) }
        }
    }

    protected abstract fun execute(parameters: P): Flow<Resource<R>>
}
