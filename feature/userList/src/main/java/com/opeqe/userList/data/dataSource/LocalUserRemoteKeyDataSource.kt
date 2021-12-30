package com.opeqe.userList.data.dataSource

import io.phoenix.businessmessenger.common.datasource.Deletable
import io.phoenix.businessmessenger.common.datasource.Readable
import io.phoenix.businessmessenger.common.datasource.Writable
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import io.phoenix.businessmessenger.data.pref.PreferenceStorage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalUserRemoteKeyDataSource @Inject constructor(private val preferenceStorage: PreferenceStorage) :
    LocalUserRemoteKeyDataSourceWritable, LocalUserRemoteKeyDataSourceReadable,
    LocalUserRemoteKeyDataSourceDeletable {
    override suspend fun write(input: UserRemoteKeyEntity) {
        preferenceStorage.saveUserRemoteKey(input)
    }

    override fun read(): Flow<UserRemoteKeyEntity> {
        return preferenceStorage.userRemoteKeyEntity
    }

    override suspend fun delete(input: Unit) {
        preferenceStorage.clearUserRemoteKey()
    }

}

interface LocalUserRemoteKeyDataSourceDeletable :
    Deletable.Suspendable<Unit>

interface LocalUserRemoteKeyDataSourceWritable :
    Writable.Suspendable<@JvmSuppressWildcards UserRemoteKeyEntity>

interface LocalUserRemoteKeyDataSourceReadable :
    Readable<@JvmSuppressWildcards Flow<UserRemoteKeyEntity>>
