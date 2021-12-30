package com.opeqe.userList.data.repository

import androidx.paging.*
import com.opeqe.userList.data.dataSource.LocalUserDataSourceReadable
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.domail.repository.UserRepository
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val pageKeyedRemoteMediator: PageKeyedRemoteMediator,
    private val localUserDataSourceReadable: LocalUserDataSourceReadable,
    private val userEntityToUser: Mapper<UserEntity, User>
) : UserRepository {


    @ExperimentalPagingApi
    override fun getUserList(
        pagingConfig: PagingConfig,
        sortType: String
    ): Flow<PagingData<User>> {
        return Pager(
            config = pagingConfig,
            remoteMediator = pageKeyedRemoteMediator,
            pagingSourceFactory = {
                localUserDataSourceReadable.read(
                    LocalUserDataSourceReadable.Params(sortType)
                )
            }
        ).flow.mapLatest { pagingData ->
            pagingData.map { entity ->
                userEntityToUser.map(entity)
            }
        }
    }


}