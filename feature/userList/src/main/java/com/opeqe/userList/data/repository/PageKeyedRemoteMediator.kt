package com.opeqe.userList.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.LoadType.*
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.opeqe.userList.data.dataSource.*
import com.opeqe.userList.data.webApi.response.UserResponse
import com.opeqe.userList.domail.entity.SortType
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.UserEntity
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PageKeyedRemoteMediator @Inject constructor(
    private val userItemMapperByPaging: Mapper<List<UserResponse>, MutableList<UserEntity>>,
    private val localRemoteKeyDataSourceReadable: LocalUserRemoteKeyDataSourceReadable,
    private val localRemoteKeyDataSourceDeletable: LocalUserRemoteKeyDataSourceDeletable,
    private val localRemoteKeyDataSourceWritable: LocalUserRemoteKeyDataSourceWritable,
    private val remoteUserByPagingDataSourceReadable: RemoteUserByPagingDataSourceReadable,
    private val localUserDataSourceWritable: LocalUserDataSourceWritable,
    private val localUserDataSourceDeletable: LocalUserDataSourceDeletable
) : RemoteMediator<Int, UserEntity>() {
    private lateinit var sortType: SortType

    operator fun invoke(parameters: SortType): PageKeyedRemoteMediator {
        sortType = parameters
        return this
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserEntity>
    ): MediatorResult {
        val loadKey = when (loadType) {
            REFRESH -> {
                UserRemoteKeyEntity(
                    nextPageKey = firstPage,
                    limit = when (loadType) {
                        REFRESH -> state.config.initialLoadSize
                        else -> state.config.pageSize
                    }
                )
            }
            PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            APPEND -> {
                localRemoteKeyDataSourceReadable.read().first()
            }
        }

        try {
            val data =
                remoteUserByPagingDataSourceReadable.read(
                    RemoteUserByPagingDataSourceReadable.Params(
                        loadKey
                    )
                )
            val dataBody = data.body()

            return if (data.isSuccessful && dataBody != null) {
                if (loadType == REFRESH) {
                    localRemoteKeyDataSourceDeletable.delete(Unit)
                    localUserDataSourceDeletable.delete(Unit)
                }
                localUserDataSourceWritable.write(
                    LocalUserDataSourceWritable.Params(
                        userItemMapperByPaging.map(dataBody.results)
                    )
                )
                localRemoteKeyDataSourceWritable.write(
                    loadKey.copy(nextPageKey = loadKey.nextPageKey + nextCounterPage)
                )
                MediatorResult.Success(
                    endOfPaginationReached = dataBody.results.isEmpty()
                )
            } else {
                MediatorResult.Success(
                    endOfPaginationReached = true
                )
            }
        } catch (e: Throwable) {
            return MediatorResult.Error(e)
        }
    }

    companion object {
        const val firstPage = 1
        const val nextCounterPage = 1
    }
}

