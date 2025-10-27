package edu.utez.mx.restaurante.ui.screens


import PrimaryButton
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
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.utez.mx.restaurante.ui.components.images.CircularImage
import edu.utez.mx.restaurante.ui.components.inputs.PasswordField
import edu.utez.mx.restaurante.viewmodel.LoginViewModel
import edu.utez.mx.restaurante.R
import edu.utez.mx.restaurante.ui.components.texts.Link
import edu.utez.mx.restaurante.ui.theme.RestauranteTheme

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
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
        Title("Restaurante")

        UserInputField(
            viewModel = viewModel,
            label = "Usuario"
        )

        PasswordField(
            viewModel = viewModel,
            label = "Contraseña"
        )

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Link("¿Has olvidado la contraseña?") {
            navController.navigate("forgot_password")
        }
        Row(
            modifier = Modifier
        ){
            PrimaryButton("Registrar"){
                navController.navigate("registro")
            }
            Spacer(modifier = Modifier.padding(5.dp))
            PrimaryButton("Iniciar sesión") {
                viewModel.login {
                    navController.navigate("menu") {
                        popUpTo("login") { inclusive = true } // Evita volver al login
                    }
                }
            }
        }

    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    RestauranteTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()

        LoginScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}