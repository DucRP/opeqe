package com.opeqe.userList.data.dataSrouce

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.opeqe.userList.data.dataSource.LocalUserRemoteKeyDataSource
import io.mockk.MockKAnnotations
import io.phoenix.businessmessenger.common.testshare.MainCoroutineRule
import io.phoenix.businessmessenger.common.testshare.runBlockingTest
import io.phoenix.businessmessenger.data.entity.UserRemoteKeyEntity
import io.phoenix.businessmessenger.data.pref.FakeSharedPreferenceStorage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LocalUserRemoteKeyDataSourceTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var localContactRemoteKeyDataSource: LocalUserRemoteKeyDataSource

    private val fakeSharedPreferenceStorage = FakeSharedPreferenceStorage()

    @Before
    fun config() {
        MockKAnnotations.init(this)
        localContactRemoteKeyDataSource = createDataSource()
    }

    private fun createDataSource(): LocalUserRemoteKeyDataSource {
        return LocalUserRemoteKeyDataSource(fakeSharedPreferenceStorage)
    }

    @Test
    fun writeLocalContactRemoteKey() = coroutineRule.runBlockingTest {
        localContactRemoteKeyDataSource.write(CONTACT_REMOTE_KEY)
        val data = fakeSharedPreferenceStorage.userRemoteKeyEntity.first()
        assert(data == CONTACT_REMOTE_KEY)
    }

    @Test
    fun readLocalContactRemoteKey() = coroutineRule.runBlockingTest {
        fakeSharedPreferenceStorage.saveUserRemoteKey(CONTACT_REMOTE_KEY)
        val data = localContactRemoteKeyDataSource.read().first()
        assert(data == CONTACT_REMOTE_KEY)
    }

    @Test
    fun clearLocalContactRemoteKey() {//todo finish it

    }

    companion object {
        val CONTACT_REMOTE_KEY = UserRemoteKeyEntity(
            nextPageKey = 1,
            limit = 10
        )
    }


}