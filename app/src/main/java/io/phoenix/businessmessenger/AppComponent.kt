package io.phoenix.businessmessenger

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.phoenix.businessmessenger.core.CoreComponent
import io.phoenix.businessmessenger.di.annotation.AppScope
import io.phoenix.businessmessenger.di.module.ActivityBindingModule

@AppScope
@Component(
    modules = [AndroidInjectionModule::class, ActivityBindingModule::class],
    dependencies = [CoreComponent::class]
)
interface AppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): AppComponent
    }

}
