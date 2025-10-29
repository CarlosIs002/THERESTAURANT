package edu.utez.mx.restaurante.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import edu.utez.mx.restaurante.data.model.Platillo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexScreen(
    titulo: String = "Menú de Platillos",
    platillos: List<Platillo>,
    onAddClick: () -> Unit,
    onPlatilloClick: (Long) -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(titulo) }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                    navController.navigate("createDish")   }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar platillo")
            }
        }
    ) { padding ->
        if (platillos.isEmpty()) {
            Box(Modifier.padding(padding), contentAlignment = Alignment.Center) {
                Text("Aún no hay platillos.\nPulsa + para agregar.", textAlign = TextAlign.Center)
            }
        } else {
            Box(Modifier.padding(padding)) {
                PlatilloList(lista = platillos) { seleccionado ->
                    onPlatilloClick(seleccionado.id.toLong())
                }
            }
        }
    }
}
