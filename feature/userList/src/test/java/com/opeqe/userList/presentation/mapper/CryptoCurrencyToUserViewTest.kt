package com.opeqe.userList.presentation.mapper

import com.opeqe.userList.domail.entity.User
import com.opeqe.userList.presentation.entity.UserView
import org.junit.Test

class CryptoCurrencyToUserViewTest {
    @Test
    fun mapTesting() {
        val data = UserToUserView().map(
            User(
                id = "1",
                name = "name",
                userName= "userName",
                age = "1"
            )
        )
        assert(
            data == UserView(
                id = "1",
                name = "name",
                userName= "userName",
                age = "1"
            )
        )
    }
}
