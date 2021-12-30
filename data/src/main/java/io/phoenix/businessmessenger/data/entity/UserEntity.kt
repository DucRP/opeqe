package io.phoenix.businessmessenger.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
//todo amir nullabel
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val userName : String,
    val id: String?,
    val name: String?,
    val age:Int?,
)