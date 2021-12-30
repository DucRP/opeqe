package com.opeqe.userList.data.mapper

import com.opeqe.userList.domail.entity.User
import io.phoenix.businessmessenger.common.mapper.Mapper
import io.phoenix.businessmessenger.data.entity.UserEntity
import javax.inject.Inject

class UserEntityToUser @Inject constructor() :
    Mapper<UserEntity, User> {
    override fun map(first: UserEntity): User {
         return User(
             id = first.id,
             name = first.name,
             age = first.age,
             userName = first.userName
         )
    }

}