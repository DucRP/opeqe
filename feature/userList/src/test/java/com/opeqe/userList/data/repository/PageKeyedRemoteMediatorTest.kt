package com.opeqe.userList.data.repository
/*

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.*
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.common.testshare.MainCoroutineRule
import io.phoenix.businessmessenger.common.testshare.runBlockingTest
import io.phoenix.businessmessenger.data.entity.ContactEntity
import io.phoenix.businessmessenger.feature.contact.data.dataSource.*
import io.phoenix.businessmessenger.feature.contact.data.webApi.response.ContactByIdResponse
import io.phoenix.businessmessenger.feature.contact.data.webApi.response.ContactListByPagingResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// todo reWork on this test
@ExperimentalCoroutinesApi
class PageKeyedRemoteMediatorTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var pageKeyedRemoteMediator: PageKeyedRemoteMediator

    private val mapper =
        mockk<Mapper<Pair<ContactListByPagingResponse, List<ContactByIdResponse>>, MutableList<ContactEntity>>>(
            relaxed = true
        )
    private val localContactRemoteKeyDataSourceReadable =
        mockk<LocalContactRemoteKeyDataSourceReadable>(relaxed = true)
    private val localContactRemoteKeyDataSourceDeletable =
        mockk<LocalContactRemoteKeyDataSourceDeletable>(relaxed = true)
    private val localContactRemoteKeyDataSourceWritable =
        mockk<LocalContactRemoteKeyDataSourceWritable>(relaxed = true)
    private val remoteContactByPagingDataSourceReadable =
        mockk<RemoteContactByPagingDataSourceReadable>(relaxed = true)
    private val remoteContactByIdDataSourceReadable =
        mockk<RemoteContactByIdDataSourceReadable>(relaxed = true)
    private val localContactDataSourceWritable =
        mockk<LocalContactDataSourceWritable>(relaxed = true)
    private val localContactDataSourceDeletable =
        mockk<LocalContactDataSourceDeletable>(relaxed = true)

    @Before
    fun config() {
        MockKAnnotations.init(this)
        pageKeyedRemoteMediator = createPageKeyedRemoteMediator()
    }

    @ExperimentalPagingApi
    @Test
    fun test() = coroutineRule.runBlockingTest {
        val data = pageKeyedRemoteMediator.load(
            LoadType.PREPEND, PagingState(
                pages = listOf(
                    PagingSource.LoadResult.Page(
                        data = emptyList(),
                        nextKey = 1,
                        prevKey = 0
                    )
                ),
                anchorPosition = 1,
                config = PagingConfig(
                    pageSize = 3
                ),
                leadingPlaceholderCount = 5
            )
        )
        assert(
            data == data
        )
    }

    private fun createPageKeyedRemoteMediator(): PageKeyedRemoteMediator {
        return PageKeyedRemoteMediator(
            contactItemMapperByPaging = mapper,
            localRemoteKeyDataSourceReadable = localContactRemoteKeyDataSourceReadable,
            localRemoteKeyDataSourceDeletable = localContactRemoteKeyDataSourceDeletable,
            localRemoteKeyDataSourceWritable = localContactRemoteKeyDataSourceWritable,
            remoteContactByPagingDataSourceReadable = remoteContactByPagingDataSourceReadable,
            remoteContactByIdDataSourceReadable = remoteContactByIdDataSourceReadable,
            localContactDataSourceWritable = localContactDataSourceWritable,
            localContactDataSourceDeletable = localContactDataSourceDeletable
        )
    }


}*/
