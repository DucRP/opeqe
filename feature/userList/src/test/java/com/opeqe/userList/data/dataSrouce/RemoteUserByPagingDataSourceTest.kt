package com.opeqe.userList.data.dataSrouce

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.opeqe.userList.data.dataSource.RemoteUserByPagingDataSource
import com.opeqe.userList.data.dataSource.RemoteUserByPagingDataSourceReadable
import com.opeqe.userList.data.webApi.response.UserResponse
import com.opeqe.userList.data.webApi.service.UserService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.phoenix.businessmessenger.common.testshare.MainCoroutineRule
import io.phoenix.businessmessenger.common.testshare.runBlockingTest
import io.phoenix.businessmessenger.data.entity.BaseResponse
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class RemoteUserByPagingDataSourceTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var remoteCryptoCurrencyByPagingDataSource: RemoteUserByPagingDataSource
    private val cryptoCurrencyService =
        mockk<UserService>(relaxed = true)

    @Before
    fun config() {
        MockKAnnotations.init(this)
        remoteCryptoCurrencyByPagingDataSource = createDataSource()
    }

    private fun createDataSource(): RemoteUserByPagingDataSource {
        return RemoteUserByPagingDataSource(cryptoCurrencyService)
    }

    @Test
    fun getRemoteCryptoCurrency() = coroutineRule.runBlockingTest {
        coEvery {
            cryptoCurrencyService.getUserListByPaging(
                any(),
                any(),
                any()
            )
        } coAnswers {
            Response.success(CryptoCurrency_LIST)
        }
        val data = remoteCryptoCurrencyByPagingDataSource.read(
            RemoteUserByPagingDataSourceReadable.Params(
                userRemoteKeyEntity = UserRemoteKeyEntity()
            )
        )
        assert(data.body() == CryptoCurrency_LIST)
    }

    companion object {
        val CryptoCurrency_LIST = BaseResponse(

            results = listOf(
                UserResponse(
                    gender="gender"
                )
            )
        )
        val ERROR = Exception(Throwable(message = "error"))
    }
}