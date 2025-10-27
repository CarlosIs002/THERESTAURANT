package edu.utez.mx.restaurante.ui.screens

import Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.ui.components.images.CircularImage
import edu.utez.mx.restaurante.viewmodel.EditDishViewModel

@Composable
fun EditDishScreen(dish: Platillo) {
    val viewModel = remember { EditDishViewModel(initialDish = dish) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = "Editar")
        Spacer(modifier = Modifier.height(16.dp))
        CircularImage(
            imageRes = viewModel.image,
            size = 150
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            label = { Text("Nombre de platillo") },
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ),onClick = { /* TODO: Handle cancel */ })
            {
                Text("Cancelar")
            }
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3)
            ),onClick = { viewModel.saveChanges() }) {
                Text("Guardar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditDishScreenPreview() {
    val sampleDish = Platillo(
        id = 1,
        nombre = "Platillo de ejemplo",
        descripcion = "Esta es una descripción de ejemplo.",
        precio = 120.50,
        image = R.drawable.enchiladas
    )
    EditDishScreen(dish = sampleDish)
}
