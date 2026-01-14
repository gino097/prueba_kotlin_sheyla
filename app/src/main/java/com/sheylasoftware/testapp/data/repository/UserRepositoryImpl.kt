package com.sheylasoftware.testapp.data.repository

import android.util.Log
import com.sheylasoftware.testapp.data.datasource.UserRemoteDataSource
import com.sheylasoftware.testapp.data.mapper.toDomain
import com.sheylasoftware.testapp.domain.model.User
import com.sheylasoftware.testapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        /*
         Reglas:
         - Obtener datos del datasource
         - Convertir DTO → dominio
         - Ignorar elementos inválidos
         - NO aplicar lógica de negocio (edad)
         */
        return remoteDataSource.fetchUsers()
            .mapNotNull { it.toDomain() }
    }
}