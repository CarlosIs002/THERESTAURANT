package edu.utez.mx.restaurante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import edu.utez.mx.restaurante.data.AppContainer
import edu.utez.mx.restaurante.ui.Navigation
import edu.utez.mx.restaurante.ui.theme.RestauranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appContainer = AppContainer(applicationContext)

        setContent {
            RestauranteTheme {
                Navigation(appContainer)
            }
        }
    }
}
