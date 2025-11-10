package edu.utez.mx.restaurante.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.ui.components.PlatilloCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexScreen(
    titulo: String = "Menú de Platillos",
    platillos: List<Platillo>,
    onAddClick: () -> Unit,
    onPlatilloClick: (Long) -> Unit,
    navController: NavController // Still needed for now, can be removed if FAB is hoisted
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(titulo) }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Agregar platillo")
            }
        }
    ) { padding ->
        if (platillos.isEmpty()) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Aún no hay platillos.\nPulsa + para agregar.", textAlign = TextAlign.Center)
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(padding),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = platillos, key = { it.id }) { platillo ->
                    PlatilloCard(p = platillo) {
                        onPlatilloClick(platillo.id)
                    }
                }
            }
        }
    }
}
