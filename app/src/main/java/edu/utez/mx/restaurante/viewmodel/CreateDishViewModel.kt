package edu.utez.mx.restaurante.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.data.repository.PlatilloRepository
import kotlinx.coroutines.launch

class CreateDishViewModel(private val repository: PlatilloRepository) : ViewModel() {
    var nombre by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var precio by mutableStateOf("")

    fun createDish() {
        val precioDouble = precio.toDoubleOrNull()

        if (nombre.isNotBlank() && descripcion.isNotBlank() && precioDouble != null) {
            viewModelScope.launch {
                repository.crear(
                    Platillo(
                        nombre = nombre,
                        descripcion = descripcion,
                        precio = precioDouble,
                        image = R.drawable.enchiladas // Placeholder
                    )
                )
            }
        } else {
            // TODO: Show error
        }
    }
}
