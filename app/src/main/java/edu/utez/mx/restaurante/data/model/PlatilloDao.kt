package edu.utez.mx.restaurante.data.model


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatilloDao {
    /** INSERT: devuelve el id autogenerado por Room */
    @Insert
    suspend fun insert(platillo: Platillo): Long
    @Update
    suspend fun update(platillo: Platillo)

    @Delete
    suspend fun delete(platillo: Platillo)

    @Query("SELECT * FROM platillos ORDER BY nombre ASC")
    fun getAll(): Flow<List<Platillo>>

    @Query("SELECT * FROM platillos WHERE id = :id")
    fun getById(id: Long): Flow<Platillo>
}
