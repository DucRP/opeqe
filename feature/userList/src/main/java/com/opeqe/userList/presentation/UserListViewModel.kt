package com.opeqe.userList.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.domail.entity.SortType
import com.opeqe.userList.domail.usecase.GetUserListUseCase
import com.opeqe.userList.presentation.entity.UserView
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.phoenix.businessmessenger.common.di.AssistedSavedStateViewModelFactory
import io.phoenix.businessmessenger.common.mapper.Mapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

class UserListViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getUserListUseCase: GetUserListUseCase,
    private val userToUserView: Mapper<User, UserView>
) : ViewModel() {
    private var sortType = SortType.none

    init {
        savedStateHandle.set(KEY_STATE, sortType)
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val cryptoCurrencyList = flowOf(
        savedStateHandle.getLiveData<String>(KEY_STATE)
            .asFlow()
            .flatMapLatest {
                getUserListUseCase(
                    GetUserListUseCase.Params(
                        sortType = it,
                        pagingConfig = PagingConfig(
                            pageSize = PAGE_SIZE,
                            initialLoadSize = INITIAL_LOAD_SIZE
                        )
                    )
                )
            }
            .cachedIn(viewModelScope)
    ).flattenMerge(DEFAULT_CONCURRENCY).mapLatest { pagingData ->
        pagingData.map { entity ->
            userToUserView.map(entity)
        }
    }

    fun rGetUser(sortT: String) {
        sortType = sortT
        savedStateHandle.set(KEY_STATE, sortType)
    }

    fun rGetLastCryptoCurrency() {
        savedStateHandle.set(KEY_STATE, sortType)
    }

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<UserListViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): UserListViewModel
    }

    companion object {
        const val PAGE_SIZE = 3
        const val INITIAL_LOAD_SIZE = 3
        const val KEY_STATE = "userList"
    }
}