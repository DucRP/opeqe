package com.opeqe.userDetail.presentation


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.opeqe.userDetail.presentation.entity.UserDetailView
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.phoenix.businessmessenger.common.di.AssistedSavedStateViewModelFactory
import io.phoenix.businessmessenger.data.entity.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserDetailViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    private val _userDetail = MutableStateFlow<Resource<UserDetailView>>(
        Resource.Success(
            UserDetailView(
                name = savedStateHandle.get<String>("name"),
                id = savedStateHandle.get<String>("id"),
                userName = savedStateHandle.get<String>("userName").orEmpty(),
                age = savedStateHandle.get<Int>("age"),
            )
        )
    )
    val userDetail: StateFlow<Resource<UserDetailView>>
        get() = _userDetail

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<UserDetailViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): UserDetailViewModel
    }

}
