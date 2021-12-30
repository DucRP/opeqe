package com.opeqe.userList.presentation.di

import com.opeqe.userList.UserListScope
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.presentation.entity.UserView
import com.opeqe.userList.presentation.mapper.UserToUserView
import dagger.Binds
import dagger.Module
import io.phoenix.businessmessenger.common.di.InjectingSavedStateViewModelFactory
import io.phoenix.businessmessenger.common.di.ViewModelFactory
import io.phoenix.businessmessenger.common.mapper.Mapper

@Module
abstract class UserListPresentationModule {

    @Binds
    @UserListScope
    abstract fun bindUserToUserView(mapper: UserToUserView): Mapper<User, UserView>


    @Binds
    @UserListScope
    abstract fun bindViewModelFactory(mapper: InjectingSavedStateViewModelFactory): ViewModelFactory


}