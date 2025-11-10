package edu.utez.mx.restaurante.ui.screens

import Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.ui.components.images.CircularImage
import edu.utez.mx.restaurante.viewmodel.EditDishViewModel
import edu.utez.mx.restaurante.viewmodel.PlatilloUiState

@Composable
fun EditDishScreen(viewModel: EditDishViewModel, nav: NavController) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.image == 0) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        EditDishContent(uiState, viewModel, nav)
    }
}

@Composable
fun EditDishContent(uiState: PlatilloUiState, viewModel: EditDishViewModel, nav: NavController) {
    var showDeleteConfirmation by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = "Editar")
        Spacer(modifier = Modifier.height(16.dp))
        CircularImage(
            imageRes = uiState.image,
            size = 150
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = uiState.nombre,
            onValueChange = { viewModel.update(uiState.copy(nombre = it)) },
            label = { Text("Nombre de platillo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = uiState.precio,
            onValueChange = { viewModel.update(uiState.copy(precio = it)) },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = uiState.descripcion,
            onValueChange = { viewModel.update(uiState.copy(descripcion = it)) },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9E9E9E)),
                onClick = { nav.popBackStack() }
            ) {
                Text("Cancelar")
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                onClick = { showDeleteConfirmation = true }
            ) {
                Text("Eliminar")
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                onClick = {
                    viewModel.update(uiState)
                    nav.popBackStack()
                }
            ) {
                Text("Guardar")
            }
        }
    }

    if (showDeleteConfirmation) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirmation = false },
            title = { Text("Confirmar eliminación") },
            text = { Text("¿Estás seguro de que quieres eliminar este platillo?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.delete()
                        showDeleteConfirmation = false
                        nav.popBackStack()
                    }
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteConfirmation = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EditDishScreenPreview() {
    val sampleUiState = PlatilloUiState(
        id = 1,
        nombre = "Platillo de ejemplo",
        descripcion = "Esta es una descripción de ejemplo.",
        precio = "120.50",
        image = R.drawable.enchiladas
    )
    // EditDishScreen(uiState = sampleUiState, onEvent = {}, onValueChange = {}) // Cannot preview with NavController
}
