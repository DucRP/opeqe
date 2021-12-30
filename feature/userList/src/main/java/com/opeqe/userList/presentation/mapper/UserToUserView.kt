package com.opeqe.userList.presentation.mapper

import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.presentation.entity.UserView
import io.phoenix.businessmessenger.common.mapper.Mapper
import javax.inject.Inject

class UserToUserView @Inject constructor() :
    Mapper<User, UserView> {
    override fun map(first: User): UserView {
        return UserView(
            id = first.id,
            name = first.name,
            age = first.age,
            userName = first.userName
        )
    }

}