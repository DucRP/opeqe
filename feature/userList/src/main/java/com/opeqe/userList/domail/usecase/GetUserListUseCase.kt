package com.opeqe.userList.domail.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.opeqe.userList.UserListScope
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.domail.entity.SortType
import com.opeqe.userList.domail.repository.UserRepository
import io.phoenix.businessmessenger.common.thread.IoDispatcher
import io.phoenix.businessmessenger.common.usecase.PagingUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@UserListScope
class GetUserListUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: UserRepository,
) : PagingUseCase<GetUserListUseCase.Params, PagingData<User>>(dispatcher) {

    override suspend fun execute(parameters: Params): Flow<PagingData<User>> {
        return repository.getUserList(parameters.pagingConfig, parameters.sortType)
    }

    data class Params(
        val pagingConfig: PagingConfig,
        val sortType: String = SortType.none
    )

}