package com.opeqe.userDetail.presentation.di

import com.opeqe.userDetail.UserDetailScope
import dagger.Binds
import dagger.Module
import io.phoenix.businessmessenger.common.di.InjectingSavedStateViewModelFactory
import io.phoenix.businessmessenger.common.di.ViewModelFactory

@Module
abstract class UserDetailPresentationModule {
    //......................Mappers...........................

    @Binds
    @UserDetailScope
    abstract fun bindViewModelFactory(mapper: InjectingSavedStateViewModelFactory): ViewModelFactory

}