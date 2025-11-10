package edu.utez.mx.restaurante.repository

import edu.utez.mx.restaurante.data.model.Platillo
import edu.utez.mx.restaurante.data.model.PlatilloDao
import kotlinx.coroutines.flow.Flow

class PlatilloRepository(private val dao: PlatilloDao) {

    /** CREATE: inserta y devuelve el id autogenerado */
    suspend fun crear(platillo: Platillo): Long = dao.insert(platillo)

    /** READ: lista reactiva de todos los platillos */
    fun listar(): Flow<List<Platillo>> = dao.getAll()
}
