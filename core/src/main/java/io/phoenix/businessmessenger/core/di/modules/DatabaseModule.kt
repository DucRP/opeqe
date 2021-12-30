package io.phoenix.businessmessenger.core.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.opeqe.businessmessenger.core.BuildConfig
import io.phoenix.businessmessenger.common.di.qualifier.ApplicationContext
import io.phoenix.businessmessenger.core.data.db.MessengerDataBase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MessengerDataBase::class.java,
        BuildConfig.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: MessengerDataBase) =
        appDatabase.getUserDao()

}
