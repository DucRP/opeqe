package io.phoenix.businessmessenger.data.pref

import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import kotlinx.coroutines.flow.Flow


interface PreferenceStorage {

    suspend fun saveUserRemoteKey(prefer: UserRemoteKeyEntity)
    suspend fun clearUserRemoteKey()
    val userRemoteKeyEntity: Flow<UserRemoteKeyEntity>


    companion object {
        val PREFS_NAME = "Opeqe"
    }
}