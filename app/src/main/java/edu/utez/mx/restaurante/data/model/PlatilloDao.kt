package edu.utez.mx.restaurante.data.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatilloDao {
    /** INSERT: devuelve el id autogenerado por Room */
    @Insert
    suspend fun insert(platillo: Platillo): Long
    @Query("SELECT * FROM platillos ORDER BY nombre ASC")
    fun getAll(): Flow<List<Platillo>>
}
