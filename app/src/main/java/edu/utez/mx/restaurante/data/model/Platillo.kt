package edu.utez.mx.restaurante.data.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "platillos")
data class Platillo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @DrawableRes val image: Int = 0,
    val nombre: String,
    val descripcion: String?,   // opcional para permitir vacío
    val precio: Double
)
