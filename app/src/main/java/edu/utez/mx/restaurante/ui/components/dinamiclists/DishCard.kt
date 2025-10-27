package edu.utez.mx.restaurante.ui.components.dinamiclists


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.utez.mx.restaurante.data.model.Platillo

@Composable
fun DishCard(
    item: Platillo,
    onClick: () -> Unit // <-- 1. ACEPTA UNA FUNCIÓN DE CLIC
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = "Imagen de platillo"
            )
            Text(
                text = "$item.id",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.nombre,
                fontSize = 14.sp
            )
            Text(
                text = "Precio: $$item.precio",
                fontSize = 14.sp
            )
            Text(
                text = item.descripcion,
                fontSize = 18.sp
            )
        }
    }
}