package com.opeqe.userList.data.mapper

import com.opeqe.userList.domail.entity.User
import io.phoenix.businessmessenger.data.entity.UserEntity
import org.junit.Test

class UserEntityToUserTest {
    @Test
    fun mapTesting() {
        val data = UserEntityToUser().map(
            UserEntity(
                id = "0",
                name = "name",
                userName = "userName",
                age = 2
            )
        )
        assert(
            data == User(
                id = "0",
                name = "name",
                userName = "userName",
                age = 2
            )
        )
    }
}