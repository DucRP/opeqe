package io.phoenix.businessmessenger.core.data.prefs

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import io.phoenix.businessmessenger.data.entity.toUserRemoteKey
import io.phoenix.businessmessenger.data.entity.toGson
import io.phoenix.businessmessenger.data.pref.PreferenceStorage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
class SharedPreferenceStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferenceStorage {

    override suspend fun saveUserRemoteKey(prefer: UserRemoteKeyEntity) {
        dataStore.edit {
            it[PreferencesKeys.CRYPTO_CURRENCY_REMOTE_KEY] = prefer.toGson()
        }
    }

    override suspend fun clearUserRemoteKey() {
        dataStore.edit {
            it.clear()
        }
    }

    override var userRemoteKeyEntity: Flow<UserRemoteKeyEntity> =
        dataStore.data.map {
            it[PreferencesKeys.CRYPTO_CURRENCY_REMOTE_KEY]?.toUserRemoteKey()
                ?: UserRemoteKeyEntity()
        }

    object PreferencesKeys {
        val CRYPTO_CURRENCY_REMOTE_KEY = stringPreferencesKey("user_key")
    }


}
