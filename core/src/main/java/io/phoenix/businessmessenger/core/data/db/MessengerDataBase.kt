package io.phoenix.businessmessenger.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.phoenix.businessmessenger.data.dao.UserDao
import io.phoenix.businessmessenger.data.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MessengerDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}