package io.phoenix.businessmessenger.core.di.modules

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import io.phoenix.businessmessenger.common.di.qualifier.ApplicationContext
import io.phoenix.businessmessenger.core.data.prefs.SharedPreferenceStorage
import io.phoenix.businessmessenger.data.pref.PreferenceStorage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Singleton

@Module
class PreferenceStorageModule {
    val Context.dataStore by preferencesDataStore(
        name = PreferenceStorage.PREFS_NAME,
        produceMigrations = { context ->
            listOf(
                SharedPreferencesMigration(
                    context,
                    PreferenceStorage.PREFS_NAME
                )
            )
        }
    )

    @ExperimentalCoroutinesApi
    @FlowPreview
    @Provides
    @Singleton
    fun providePreferenceStorage(@ApplicationContext context: Context): PreferenceStorage {
        return SharedPreferenceStorage(context.dataStore)
    }

}