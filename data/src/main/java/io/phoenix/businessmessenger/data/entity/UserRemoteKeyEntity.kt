package io.phoenix.businessmessenger.data.entity

import com.google.gson.Gson

data class UserRemoteKeyEntity(
    val nextPageKey: Int = 0,
    val limit: Int = 0
)

fun UserRemoteKeyEntity.toGson(): String {
    return Gson().toJson(this)
}

fun String.toUserRemoteKey(): UserRemoteKeyEntity {
    return Gson().fromJson(this, UserRemoteKeyEntity::class.java)
}
