package com.sheylasoftware.testapp.data.datasource

import com.sheylasoftware.testapp.data.model.UserDto
import kotlinx.coroutines.delay

interface UserRemoteDataSource {
    suspend fun fetchUsers(): List<UserDto>
}

class FakeUserRemoteDataSource : UserRemoteDataSource {
    override suspend fun fetchUsers(): List<UserDto> {
        delay(300)
        return listOf(
            UserDto(1, "Ana", 25),
            UserDto(2, null, 30),
            UserDto(3, "Luis", 15),
            UserDto(null, "Pedro", 40)
        )
    }
}