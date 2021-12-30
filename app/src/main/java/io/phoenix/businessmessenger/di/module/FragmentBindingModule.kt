package io.phoenix.businessmessenger.di.module


import com.opeqe.userDetail.UserDetailScope
import com.opeqe.userDetail.presentation.UserDetailFragment
import com.opeqe.userDetail.presentation.di.UserDetailAssistedModule
import com.opeqe.userDetail.presentation.di.UserDetailPresentationModule
import com.opeqe.userList.UserListScope
import com.opeqe.userList.data.di.UserDataModule
import com.opeqe.userList.presentation.UserFragment
import com.opeqe.userList.presentation.di.UserListAssistedModule
import com.opeqe.userList.presentation.di.UserListPresentationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {
    @UserListScope
    @ContributesAndroidInjector(modules = [UserListPresentationModule::class, UserListAssistedModule::class, UserDataModule::class])
    internal abstract fun bindCryptoCurrencyFragment(): UserFragment

    @UserDetailScope
    @ContributesAndroidInjector(modules = [UserDetailPresentationModule::class, UserDetailAssistedModule::class])
    internal abstract fun bindCryptoCurrencyDetailFragment(): UserDetailFragment
}