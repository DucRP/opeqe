package com.opeqe.userList.presentation.di

import androidx.lifecycle.ViewModel
import com.opeqe.userList.UserListScope
import com.opeqe.userList.presentation.UserListViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.phoenix.businessmessenger.common.di.AssistedSavedStateViewModelFactory
import io.phoenix.businessmessenger.common.di.ViewModelKey

@AssistedModule
@Module(includes = [AssistedInject_UserListAssistedModule::class])
abstract class UserListAssistedModule {
    @Binds
    @IntoMap
    @UserListScope
    @ViewModelKey(UserListViewModel::class)
    abstract fun bindVMFactory(f: UserListViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}