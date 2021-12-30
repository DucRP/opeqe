package io.phoenix.businessmessenger.core

import android.app.Application
import android.content.Context
import dagger.Component
import io.phoenix.businessmessenger.common.di.qualifier.ApplicationContext
import io.phoenix.businessmessenger.common.thread.DefaultDispatcher
import io.phoenix.businessmessenger.common.thread.IoDispatcher
import io.phoenix.businessmessenger.common.thread.MainDispatcher
import io.phoenix.businessmessenger.core.di.modules.*
import io.phoenix.businessmessenger.data.dao.UserDao
import io.phoenix.businessmessenger.data.pref.PreferenceStorage
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        ContextModule::class,
        CoroutinesModule::class,
        PreferenceStorageModule::class]
)
@Singleton
interface CoreComponent {
    @ApplicationContext
    fun provideContext(): Context

    fun application(): Application

    @IoDispatcher
    fun getIoDispatcher(): CoroutineDispatcher

    @MainDispatcher
    fun getMainDispatcher(): CoroutineDispatcher

    @DefaultDispatcher
    fun getDefaultDispatcher(): CoroutineDispatcher
    fun getPreferenceStorage(): PreferenceStorage
    fun getRetrofit(): Retrofit
    fun getUserDao(): UserDao
}
