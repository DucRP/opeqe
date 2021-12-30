package io.phoenix.businessmessenger.core.di.modules

import dagger.Module
import dagger.Provides
import io.phoenix.businessmessenger.common.thread.DefaultDispatcher
import io.phoenix.businessmessenger.common.thread.IoDispatcher
import io.phoenix.businessmessenger.common.thread.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object CoroutinesModule {

    @DefaultDispatcher
    @Provides
    @Singleton
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    @Singleton
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    @Singleton
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
