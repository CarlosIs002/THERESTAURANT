package edu.utez.mx.restaurante.ui.screens

import Title
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.ui.components.images.CircularImage
import edu.utez.mx.restaurante.viewmodel.CreateDishViewModel

@Composable
fun CreateDishScreen(viewModel: CreateDishViewModel, nav: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = "Nuevo Platillo")
        Spacer(modifier = Modifier.height(20.dp))
        CircularImage(
            imageRes = R.drawable.enchiladas,
            size = 150
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.precio,
            onValueChange = { viewModel.precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.descripcion,
            onValueChange = { viewModel.descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3)
            ),
            onClick = {
                viewModel.createDish()
                nav.navigate("menu") { popUpTo("menu") { inclusive = true } }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Crear Platillo")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9E9E9E) // Gray color for cancel
            ),
            onClick = { nav.popBackStack() }, // Go back
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancelar")
        }
    }
}
