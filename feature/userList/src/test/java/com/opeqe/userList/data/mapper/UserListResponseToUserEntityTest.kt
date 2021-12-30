package com.opeqe.userList.data.mapper


import com.opeqe.userList.data.webApi.response.LoginResponse
import com.opeqe.userList.data.webApi.response.UserResponse
import io.phoenix.businessmessenger.data.entity.UserEntity
import org.junit.Test

class UserListResponseToUserEntityTest {
    @Test
    fun mapTestingHaveItem() {

        val data = UserResponseListToUserEntityList().map(
            listOf(
                UserResponse(
                    login = LoginResponse(
                        username = "useAmir"
                    )
                )
            )
        )
        assert(
            data[0] == listOf(
                UserEntity(
                    userName = "userAmir",
                    id = null,
                    name = null,
                    age = null
                )
            )[0]
        )
        assert(data.size == 1)
    }

    @Test
    fun mapTestingNotHaveThumbnailItem() {

        val data = UserResponseListToUserEntityList().map(
            emptyList()
        )
        assert(
            data.isEmpty()
        )
    }

}