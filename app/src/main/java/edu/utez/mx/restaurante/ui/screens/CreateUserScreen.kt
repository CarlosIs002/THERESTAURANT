package edu.utez.mx.restaurante.ui.screens

import PrimaryButton
import RegisterUserInputField
import Title
import UserInputField
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.ui.components.images.CircularImage
import edu.utez.mx.restaurante.ui.components.inputs.PasswordField
import edu.utez.mx.restaurante.ui.components.texts.Link
import edu.utez.mx.restaurante.ui.theme.RestauranteTheme
import edu.utez.mx.restaurante.viewmodel.CreateUserViewModel
import edu.utez.mx.restaurante.viewmodel.LoginViewModel

@Composable
fun CreateUserScreen(viewModel: CreateUserViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        CircularImage(R.drawable.restaurante)
        Title("Registro de usuario")

        RegisterUserInputField(
            viewModel = viewModel,
            label = "Correo"
        )
        RegisterUserInputField(
            viewModel = viewModel,
            label = "Contraseña"
        )
        RegisterUserInputField(
            viewModel = viewModel,
            label = "Telefono"
        )
        RegisterUserInputField(
            viewModel = viewModel,
            label = "Usuario"
        )

        if (viewModel.createError.value.isNotEmpty()) {
            Text(
                text = viewModel.createError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
        ){
            PrimaryButton("Cancelar"){
                navController.navigate("login")
            }
            Spacer(modifier = Modifier.padding(5.dp))
            PrimaryButton("Iniciar sesión") {
                viewModel.create {
                    navController.navigate("login") {
                        popUpTo("registeruser") { inclusive = true } // Evita volver al login
                    }
                }
            }
        }

    }
}
@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewCreateUserScreen() {
    RestauranteTheme {
        val navController = rememberNavController()
        val viewModel = CreateUserViewModel()

        CreateUserScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}