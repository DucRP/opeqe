package com.opeqe.userList.domain.usecase


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.domail.repository.UserRepository
import com.opeqe.userList.domail.usecase.GetUserListUseCase
import com.opeqe.userList.presentation.UserListViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.phoenix.businessmessenger.common.testshare.MainCoroutineRule
import io.phoenix.businessmessenger.common.testshare.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetUserUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var getUserListUseCase: GetUserListUseCase

    private val cryptoCurrencyRepository = mockk<UserRepository>(relaxed = true)

    @Before
    fun config() {
        MockKAnnotations.init(this)
        getUserListUseCase = createUseCase()
    }

    @Test
    fun getContactConfigSuccess() = coroutineRule.runBlockingTest {
        every { cryptoCurrencyRepository.getUserList(any(), any()) } answers {
            flow {
                PagingData.from(
                    DATA
                )
            }
        }

        getUserListUseCase(
            GetUserListUseCase.Params(
                pagingConfig = PagingConfig(
                    pageSize = UserListViewModel.PAGE_SIZE,
                    initialLoadSize = UserListViewModel.INITIAL_LOAD_SIZE
                )
            )
        ).collect {
            assert(it == DATA)
        }
    }

    private fun createUseCase(): GetUserListUseCase {
        return GetUserListUseCase(
            dispatcher = coroutineRule.testDispatcher,
            repository = cryptoCurrencyRepository
        )
    }

    companion object {
        val ERROR = Exception(Throwable(message = "error"))
        val DATA = listOf(
            User(
                id = "1",
                name = "name",
                userName = "userName",
                age = "userName",
            )
        )
    }

}
