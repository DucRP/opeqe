package com.opeqe.userList.data.dataSource

import com.opeqe.userList.data.webApi.response.UserResponse
import com.opeqe.userList.data.webApi.service.UserService
import io.phoenix.businessmessenger.common.datasource.Readable
import io.phoenix.businessmessenger.data.entity.BaseResponse
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import retrofit2.Response
import javax.inject.Inject

class RemoteUserByPagingDataSource @Inject constructor(private val userService: UserService) :
    RemoteUserByPagingDataSourceReadable {
    override suspend fun read(input: RemoteUserByPagingDataSourceReadable.Params): Response<BaseResponse<List<UserResponse>>> {
        return userService.getUserListByPaging(
            page = input.userRemoteKeyEntity.nextPageKey,
            size = input.userRemoteKeyEntity.limit
        )
    }
}

interface RemoteUserByPagingDataSourceReadable :
    Readable.Suspendable.IO<RemoteUserByPagingDataSourceReadable.Params, @JvmSuppressWildcards Response<BaseResponse<List<UserResponse>>>> {
    data class Params(val userRemoteKeyEntity: UserRemoteKeyEntity)
}