package com.opeqe.userList.data.di

import com.opeqe.userList.UserListScope
import com.opeqe.userList.data.dataSource.*
import com.opeqe.userList.data.mapper.UserEntityToUser
import com.opeqe.userList.data.mapper.UserResponseListToUserEntityList
import com.opeqe.userList.data.repository.UserRepositoryImpl
import com.opeqe.userList.data.webApi.response.UserResponse
import com.opeqe.userList.data.webApi.service.UserService
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.domail.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.UserEntity
import retrofit2.Retrofit

@Module
abstract class UserDataModule {
    //......................Mappers...........................

    @Binds
    @UserListScope
    abstract fun bindUserEntityToUser(mapper: UserEntityToUser): Mapper<UserEntity, User>

    @Binds
    @UserListScope
    abstract fun bindUserListResponseToUserEntity(mapper: UserResponseListToUserEntityList): Mapper<@JvmSuppressWildcards List<UserResponse>, @JvmSuppressWildcards List<UserEntity>>


    //......................DataSource...........................

    @Binds
    @UserListScope
    abstract fun bindRemoteUserDataSourceReadable(dataSource: RemoteUserByPagingDataSource): RemoteUserByPagingDataSourceReadable


    @Binds
    @UserListScope
    abstract fun bindLocalUserRemoteKeyDataSourceWritable(dataSource: LocalUserRemoteKeyDataSource): LocalUserRemoteKeyDataSourceWritable

    @Binds
    @UserListScope
    abstract fun bindLocalUserLocalUserRemoteKeyDataSourceReadable(dataSource: LocalUserRemoteKeyDataSource): LocalUserRemoteKeyDataSourceReadable

    @Binds
    @UserListScope
    abstract fun bindLocalUserRemoteKeyDataSourceDeletable(dataSource: LocalUserRemoteKeyDataSource): LocalUserRemoteKeyDataSourceDeletable

    @Binds
    @UserListScope
    abstract fun bindLocalUserDataSourceReadable(dataSource: LocalUserListDataSource): LocalUserDataSourceReadable

    @Binds
    @UserListScope
    abstract fun bindLocalUserDataSourceWritable(dataSource: LocalUserListDataSource): LocalUserDataSourceWritable

    @Binds
    @UserListScope
    abstract fun bindLocalUserDataSourceDeletable(dataSource: LocalUserListDataSource): LocalUserDataSourceDeletable


    //......................Repository...........................

    @Binds
    @UserListScope
    abstract fun bindUserRepositoryImpl(repo: UserRepositoryImpl): UserRepository


    companion object {
        @Provides
        @UserListScope
        fun provideApiService(retrofit: Retrofit): UserService {
            return retrofit.create(UserService::class.java)
        }
    }

}