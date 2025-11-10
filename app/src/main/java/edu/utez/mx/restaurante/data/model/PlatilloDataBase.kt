package edu.utez.mx.restaurante.data.model


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Platillo::class], version = 1, exportSchema = false)
abstract class PlatilloDataBase : RoomDatabase() {
    abstract fun platilloDao(): PlatilloDao

    companion object {
        @Volatile private var INSTANCE: PlatilloDataBase? = null

        fun get(context: Context): PlatilloDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PlatilloDataBase::class.java,
                    "restaurante.db"
                ).build().also { INSTANCE = it }
            }
    }
}
