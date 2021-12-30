package com.opeqe.userList.data.dataSource

import androidx.paging.PagingSource
import com.opeqe.userList.domail.entity.SortType
import io.phoenix.businessmessenger.common.datasource.Deletable
import io.phoenix.businessmessenger.common.datasource.Readable
import io.phoenix.businessmessenger.common.datasource.Writable
import io.phoenix.businessmessenger.data.dao.UserDao
import io.phoenix.businessmessenger.data.entity.UserEntity
import javax.inject.Inject

class LocalUserListDataSource @Inject constructor(private val userDao: UserDao) :
    LocalUserDataSourceReadable, LocalUserDataSourceWritable,
    LocalUserDataSourceDeletable {
    override fun read(input: LocalUserDataSourceReadable.Params): PagingSource<Int, UserEntity> {
        when (input.sortType) {
            SortType.name -> {
                return userDao.getAllByName()
            }
            SortType.userName -> {
                return userDao.getAllByUserName()

            }
            SortType.age -> {
                return userDao.getAllByAge()
            }
            else -> {
                return userDao.getAll()
            }
        }
    }

    override suspend fun write(input: LocalUserDataSourceWritable.Params) {
        userDao.insertAll(input.list)
    }

    override fun delete(input: Unit) {
        userDao.deleteAll()
    }

}

interface LocalUserDataSourceReadable :
    Readable.IO<LocalUserDataSourceReadable.Params, @JvmSuppressWildcards PagingSource<Int, UserEntity>> {
    data class Params(val sortType: String)
}

interface LocalUserDataSourceWritable :
    Writable.Suspendable<@JvmSuppressWildcards LocalUserDataSourceWritable.Params> {
    data class Params(val list: List<UserEntity>)
}

interface LocalUserDataSourceDeletable : Deletable<Unit>


