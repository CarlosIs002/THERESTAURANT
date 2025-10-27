package edu.utez.mx.restaurante.ui.screens

import PrimaryButton
import Title
import UserInputField
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.utez.mx.restaurante.ui.components.inputs.NewPassInputField
import edu.utez.mx.restaurante.ui.theme.RestauranteTheme
import edu.utez.mx.restaurante.viewmodel.ContrasenaViewModel

@Composable
fun ContrasenaScreen(viewModel: ContrasenaViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Title("Recuperar contraseña")

            Text(
                "Ingrese su correo electrónico para recibir instrucciones para restablecer su contraseña.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 10.dp),

                )
        Column(
            modifier = Modifier
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
        ) {
            NewPassInputField(
                viewModel = viewModel,
                label = "Correo"
            )

        }

        Row(
            modifier = Modifier
                .padding(20.dp)
        ){
            PrimaryButton("Enviar"){
                navController.navigate("login")
            }
            Spacer(modifier = Modifier.padding(5.dp))
            PrimaryButton("Cancelar"){
                navController.navigate("login")
            }

        }

    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewContrasenaScreen() {
    RestauranteTheme {
        val navController = rememberNavController()
        val viewModel = ContrasenaViewModel()

        ContrasenaScreen(
            viewModel = viewModel,
            navController = navController
        )

    }

}