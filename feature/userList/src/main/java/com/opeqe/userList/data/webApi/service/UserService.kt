package com.opeqe.userList.data.webApi.service

import com.opeqe.userList.data.webApi.response.UserResponse
import io.phoenix.businessmessenger.data.entity.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("api/")
    suspend fun getUserListByPaging(
        @Query("page") page: Int,
        @Query("result") size: Int,
        @Query("seed") convert: String = "abc"
    ): Response<BaseResponse<List<UserResponse>>>

}

