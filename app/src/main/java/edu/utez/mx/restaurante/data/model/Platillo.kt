package edu.utez.mx.restaurante.data.model

import androidx.annotation.DrawableRes

data class Platillo (
    val id: Int,
    @DrawableRes val image: Int,
    val nombre: String,
    val descripcion:String,
    val precio: Double
)