package com.opeqe.userList.presentation.interfaces

import com.opeqe.userList.presentation.entity.UserView


interface UserListAction {
    fun onItemClick(user: UserView)
}