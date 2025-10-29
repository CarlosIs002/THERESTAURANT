package edu.utez.mx.restaurante.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextOverflow
import java.text.NumberFormat
import java.util.Locale
import edu.utez.mx.restaurante.data.model.Platillo

@Composable
fun PlatilloCard(
    p: Platillo,
    onClick: (Platillo) -> Unit
) {
    ElevatedCard(
        onClick = { onClick(p) },
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp), // <-- más alto
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(p.image),
                contentDescription = "imagen del platillo",
                modifier = Modifier
                    .size(84.dp) // <-- imagen más grande
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = p.nombre,
                    style = MaterialTheme.typography.titleLarge, // <-- texto más grande
                    fontWeight = FontWeight.SemiBold
                )  // DESCRIPCIÓN
                Text(
                    text = p.descripcion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(6.dp))

                // PRECIO
                Text(
                    text = formatCurrency(p.precio),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
    }
}

private fun formatCurrency(price: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
    return format.format(price)
}
