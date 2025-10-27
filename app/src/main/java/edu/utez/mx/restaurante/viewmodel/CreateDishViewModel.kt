package edu.utez.mx.restaurante.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import edu.utez.mx.restaurante.data.model.Platillo

class CreateDishViewModel {
    var nombre by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var precio by mutableStateOf("")
    var image by mutableStateOf(0) // Placeholder

    fun createDish() {
        val precioDouble = precio.toDoubleOrNull()

        if (nombre.isNotBlank() && descripcion.isNotBlank() && precioDouble != null) {
            val newDish = Platillo(
                id = 0, // El ID debería ser generado por tu backend/base de datos
                nombre = nombre,
                descripcion = descripcion,
                precio = precioDouble,
                image = image
            )

            // TODO: Aquí llamarías al repositorio para guardar el nuevo platillo
            println("Platillo creado: $newDish")

            clearFields()
        } else {
            // TODO: Mostrar un mensaje de error al usuario
            println("Error: Todos los campos son requeridos")
        }
    }

    private fun clearFields() {
        nombre = ""
        descripcion = ""
        precio = ""
    }
}
