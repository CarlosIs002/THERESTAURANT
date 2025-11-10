package edu.utez.mx.restaurante.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.data.repository.PlatilloRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PlatilloListViewModel(private val repository: PlatilloRepository) : ViewModel() {

    val items: StateFlow<List<Platillo>> = repository.listar()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            if (repository.listar().first().isEmpty()) {
                repository.crear(Platillo(nombre = "Pollo en salsa verde", descripcion = "Tiene queso", precio = 70.0, image = R.drawable.enchiladas))
                repository.crear(Platillo(nombre = "Pozonque", descripcion = "Tiene queso", precio = 70.0, image = R.drawable.enchiladas))
                repository.crear(Platillo(nombre = "Enchiladas negras", descripcion = "Tiene queso", precio = 70.0, image = R.drawable.enchiladas))
                repository.crear(Platillo(nombre = "Enchiladas verdes", descripcion = "Tiene queso", precio = 70.0, image = R.drawable.enchiladas))
                repository.crear(Platillo(nombre = "Enchiladas rojas", descripcion = "Tiene queso", precio = 70.0, image = R.drawable.enchiladas))
            }
        }
    }

    fun onItemClicked(item: Platillo) {
        println("Click en platillo: ${item.nombre}")
        // Aquí podrías disparar navegación, selección, etc.
    }
}
