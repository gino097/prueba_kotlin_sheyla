package com.sheylasoftware.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sheylasoftware.testapp.di.ServiceLocator
import com.sheylasoftware.testapp.domain.model.User
import com.sheylasoftware.testapp.ui.theme.TestappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestappTheme {
                val viewModel = ServiceLocator.provideUserViewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun UserScreen(
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val users by viewModel.users

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = { viewModel.loadUsers() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cargar usuarios")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (users.isEmpty()) {
            Text(text = "No hay usuarios cargados")
        } else {
            LazyColumn {
                items(users) { user ->
                    UserItem(user)
                }
            }
        }
    }
}


@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = user.name, style = MaterialTheme.typography.titleMedium)
        Text(text = "Edad: ${user.age}")
    }
}