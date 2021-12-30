package com.opeqe.userList.data.mapper

import com.opeqe.userList.data.webApi.response.UserResponse
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.UserEntity
import javax.inject.Inject

class UserResponseListToUserEntityList @Inject constructor() :
    Mapper<@JvmSuppressWildcards List<UserResponse>, @JvmSuppressWildcards List<UserEntity>> {

    override fun map(first: List<UserResponse>): List<UserEntity> {
        return first.map {
            UserEntity(
                id = it.id?.value,
                name = it.name?.getFullName(),
                age = it.registered?.age,
                userName = it.login?.username ?: it.name?.getFullName().orEmpty()
            )
        }
    }
}