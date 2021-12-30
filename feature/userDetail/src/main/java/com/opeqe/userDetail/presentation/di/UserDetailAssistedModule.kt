package com.opeqe.userDetail.presentation.di

import androidx.lifecycle.ViewModel
import com.opeqe.userDetail.UserDetailScope
import com.opeqe.userDetail.presentation.UserDetailViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.phoenix.businessmessenger.common.di.AssistedSavedStateViewModelFactory
import io.phoenix.businessmessenger.common.di.ViewModelKey

@AssistedModule
@Module(includes = [AssistedInject_UserDetailAssistedModule::class])
abstract class UserDetailAssistedModule {
    @Binds
    @IntoMap
    @UserDetailScope
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun bindVMFactory(f: UserDetailViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}