package edu.utez.mx.restaurante.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.data.repository.PlatilloRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EditDishViewModel(private val repository: PlatilloRepository, savedStateHandle: SavedStateHandle) : ViewModel() {

    private val platilloId: Long = checkNotNull(savedStateHandle["id"])

    val uiState: StateFlow<PlatilloUiState> = repository.getById(platilloId)
        .filterNotNull()
        .map {
            PlatilloUiState(it.id, it.nombre, it.descripcion ?: "", it.precio.toString(), it.image)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = PlatilloUiState()
        )

    fun update(platilloUiState: PlatilloUiState) {
        val precioDouble = platilloUiState.precio.toDoubleOrNull()
        if (precioDouble != null) {
            viewModelScope.launch {
                repository.actualizar(platilloUiState.toPlatillo(precioDouble))
            }
        }
    }

    fun delete() {
        viewModelScope.launch {
            repository.eliminar(uiState.value.toPlatillo(uiState.value.precio.toDouble()))
        }
    }

    private fun PlatilloUiState.toPlatillo(precio: Double): Platillo = Platillo(
        id = id,
        nombre = nombre,
        descripcion = descripcion,
        precio = precio,
        image = image
    )
}
