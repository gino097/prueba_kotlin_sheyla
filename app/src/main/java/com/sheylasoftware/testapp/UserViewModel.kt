package com.sheylasoftware.testapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheylasoftware.testapp.domain.model.User
import com.sheylasoftware.testapp.domain.usecase.GetAdultUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val getAdultUsersUseCase: GetAdultUsersUseCase
): ViewModel() {
    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = getAdultUsersUseCase()
            Log.v("exex", "${_users.value}")
        }
    }
}
