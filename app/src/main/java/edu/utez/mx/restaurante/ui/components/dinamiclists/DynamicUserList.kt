package edu.utez.mx.restaurante.ui.components.dinamiclists

import android.R.attr.onClick
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.utez.mx.restaurante.data.model.Platillo


@Composable
fun DynamicUserList(
    items: List<Platillo>,
    onItemClick: (Platillo) -> Unit // <-- 1. ACEPTA UNA ACCIÓN POR USUARIO (Tambien manda al usuario a la acción)
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = items, key = { it.id }) { item ->
            DishCard(
                item = item,
                onClick = { onItemClick(item) } // <-- 2. PASA LA ACCIÓN AL ELEMENTO UserCard
            )
        }
    }
}