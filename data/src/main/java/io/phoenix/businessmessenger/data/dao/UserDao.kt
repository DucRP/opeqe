package io.phoenix.businessmessenger.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import io.phoenix.businessmessenger.data.entity.UserEntity


@Dao
interface UserDao : BaseDao<UserEntity> {
    @Query("SELECT * FROM user ")
    fun getAll(): PagingSource<Int, UserEntity>

    @Query("SELECT * FROM user order by age asc")
    fun getAllByAge(): PagingSource<Int, UserEntity>

    @Query("SELECT * FROM user order by name asc")
    fun getAllByName(): PagingSource<Int, UserEntity>

    @Query("SELECT * FROM user order by userName asc")
    fun getAllByUserName(): PagingSource<Int, UserEntity>

    @Query("SELECT * FROM user ")
    fun getAllList(): List<UserEntity>

    @Query("DELETE FROM user ")
    fun deleteAll()

}
