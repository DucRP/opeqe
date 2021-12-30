package io.phoenix.businessmessenger.core.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.phoenix.businessmessenger.common.di.qualifier.ApplicationContext


@Module
class ContextModule(private val application: Application) {

    /**
     * Create a provider method binding for [Context].
     *
     * @return Instance of context.
     * @see Provides
     */
    @ApplicationContext
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Provides
    fun provideApplication(): Application = application
}
