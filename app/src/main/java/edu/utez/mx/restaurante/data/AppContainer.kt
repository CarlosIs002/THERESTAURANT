package edu.utez.mx.restaurante.data

import android.content.Context
import edu.utez.mx.restaurante.data.model.PlatilloDataBase
import edu.utez.mx.restaurante.data.repository.PlatilloRepository

class AppContainer(context: Context) {
    val platilloRepository by lazy {
        PlatilloRepository(PlatilloDataBase.get(context).platilloDao())
    }
}