package com.example.authapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormScreen(
    formViewModel: FormViewModel,
    onSubmissionSuccess: () -> Unit,
    onNavigateBack: () -> Unit )
{
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = field1,
            onValueChange = { field1 = it },
            label = { Text("Campo 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = field2,
            onValueChange = { field2 = it },
            label = { Text("Campo 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            formViewModel.submit(field1, field2.toIntOrNull() ?: 0)
        }) {
            Text("Enviar")
        }
        Button(onClick = onNavigateBack) {
            Text("Regresar a Home")
        }
    }
}