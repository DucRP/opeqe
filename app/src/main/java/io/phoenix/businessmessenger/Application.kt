package io.phoenix.businessmessenger


import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.phoenix.businessmessenger.core.CoreComponent
import io.phoenix.businessmessenger.core.DaggerCoreComponent
import io.phoenix.businessmessenger.core.di.modules.ContextModule
import timber.log.Timber

class Application : DaggerApplication() {
    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .coreComponent(getCoreComponent())
            .build()
    }

    private fun getCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
        }

        return coreComponent
    }

}