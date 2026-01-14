package com.sheylasoftware.testapp.di

import com.sheylasoftware.testapp.UserViewModel
import com.sheylasoftware.testapp.data.datasource.FakeUserRemoteDataSource
import com.sheylasoftware.testapp.data.repository.UserRepositoryImpl
import com.sheylasoftware.testapp.domain.usecase.GetAdultUsersUseCase

object ServiceLocator {

    /*Aqui deben crear el ViewModel pasandole las dependencias necesarias*/
    fun provideUserViewModel(): UserViewModel {
        val dataSource = FakeUserRemoteDataSource()
        val repository = UserRepositoryImpl(dataSource)
        val useCase = GetAdultUsersUseCase(repository)
        return UserViewModel(useCase)
    }
}

