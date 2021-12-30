package com.opeqe.userList.domail.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.opeqe.userList.domail.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
      fun getUserList(
          pagingConfig: PagingConfig,
          sortType: String
      ): Flow<PagingData<User>>
}