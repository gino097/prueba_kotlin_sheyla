package com.sheylasoftware.testapp.domain.repository

import com.sheylasoftware.testapp.domain.model.User

interface UserRepository{
    suspend fun getUsers(): List<User>
}