package edu.utez.mx.restaurante.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import edu.utez.mx.restaurante.data.model.Platillo

class EditDishViewModel(private val initialDish: Platillo) {

    var nombre by mutableStateOf(initialDish.nombre)
    var descripcion by mutableStateOf(initialDish.descripcion)
    var precio by mutableStateOf(initialDish.precio.toString())
    var image by mutableStateOf(initialDish.image)

    fun saveChanges() {
        val precioDouble = precio.toDoubleOrNull()

        if (nombre.isNotBlank() && descripcion.isNotBlank() && precioDouble != null) {
            val updatedDish = initialDish.copy(
                nombre = nombre,
                descripcion = descripcion,
                precio = precioDouble,
                image = image
            )


            println("Platillo guardado: $updatedDish")
        } else {
            println("Error: Todos los campos son requeridos")
        }
    }
}
