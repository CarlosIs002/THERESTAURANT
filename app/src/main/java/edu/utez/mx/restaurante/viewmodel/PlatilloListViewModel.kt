package edu.utez.mx.restaurante.viewmodel

import androidx.lifecycle.ViewModel
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.data.model.Platillo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlatilloListViewModel : ViewModel() {

    // 1) Estado interno (mutable solo para el VM)
    private val _items = MutableStateFlow<List<Platillo>>(emptyList())

    // 2) Exposición a la UI (inmutable)
    val items: StateFlow<List<Platillo>> = _items

    init {
        loadItems()
    }

    // 3) Evento desde la UI
    fun onItemClicked(item: Platillo) {
        println("Click en platillo: ${item.nombre}")
        // Aquí podrías disparar navegación, selección, etc.
    }

    private fun loadItems() {
        // Demo: usa tu imagen enchiladas.jpg en /res/drawable (R.drawable.enchiladas)
        _items.value = listOf(
            Platillo(1, R.drawable.enchiladas, "Pollo en salsa verde", "Tiene queso", 70.0  ),
            Platillo(2, R.drawable.enchiladas, "Pozonque", "Tiene queso", 70.0  ),
            Platillo(3, R.drawable.enchiladas, "Enchiladas negras", "Tiene queso", 70.0  ),
            Platillo(4, R.drawable.enchiladas, "Enchiladas verdes", "Tiene queso", 70.0  ),
            Platillo(5, R.drawable.enchiladas, "Enchiladas rojas", "Tiene queso", 70.0  ),

            )
    }
}
