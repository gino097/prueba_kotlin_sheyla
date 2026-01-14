package com.sheylasoftware.testapp.domain.usecase

import com.sheylasoftware.testapp.domain.model.User
import com.sheylasoftware.testapp.domain.repository.UserRepository

class GetAdultUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        return repository
            .getUsers()
            .filter { it.age >= 18 }
    }
}