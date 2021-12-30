package io.phoenix.businessmessenger.data.pref

import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


class FakeSharedPreferenceStorage : PreferenceStorage {
    override suspend fun saveUserRemoteKey(prefer: UserRemoteKeyEntity) {
        _iamConfigEntity.value = prefer
    }

    override suspend fun clearUserRemoteKey() {// todo finish it

    }

    private val _iamConfigEntity = MutableStateFlow(UserRemoteKeyEntity())
    override val userRemoteKeyEntity: Flow<UserRemoteKeyEntity> =
        _iamConfigEntity
}
