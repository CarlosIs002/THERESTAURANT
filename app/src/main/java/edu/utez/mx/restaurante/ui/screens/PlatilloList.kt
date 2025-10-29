package edu.utez.mx.restaurante.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.ui.components.PlatilloCard
import edu.utez.mx.restaurante.ui.theme.RestauranteTheme

@Composable
fun PlatilloList(lista: List<Platillo>, onItemClick: (Platillo) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(items = lista, key = { it.id }) { platillo ->
            PlatilloCard(platillo) { onItemClick(platillo) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlatilloList(){
    val lista = listOf(
        Platillo(
            1,
            R.drawable.enchiladas,
            "Enchiladas suizas",
            "sizas bro",
            18.0
        ),
        Platillo(
            2,
            R.drawable.enchiladas,
            "Enchiladas",
            "Enchiladas al estilo insano",
            500.0
        ), Platillo(
            3,
            R.drawable.enchiladas,
            "Enchiladas",
            "Enchiladas al estilo insano",
            500.0
        ),
        Platillo(
            4,
            R.drawable.enchiladas,
            "Enchiladas",
            "Enchiladas al estilo insano",
            500.0
        ),
    )
    RestauranteTheme {
        PlatilloList(lista) { }
    }
}