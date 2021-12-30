package io.phoenix.businessmessenger.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.phoenix.businessmessenger.MainActivity
import io.phoenix.businessmessenger.di.annotation.ActivityScoped

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBindingModule::class])
    internal abstract fun mainActivity(): MainActivity
}