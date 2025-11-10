package edu.utez.mx.restaurante.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.utez.mx.restaurante.data.AppContainer
import edu.utez.mx.restaurante.ui.screens.ContrasenaScreen
import edu.utez.mx.restaurante.ui.screens.CreateDishScreen
import edu.utez.mx.restaurante.ui.screens.CreateUserScreen
import edu.utez.mx.restaurante.ui.screens.EditDishScreen
import edu.utez.mx.restaurante.ui.screens.IndexScreen
import edu.utez.mx.restaurante.ui.screens.LoginScreen
import edu.utez.mx.restaurante.viewmodel.ContrasenaViewModel
import edu.utez.mx.restaurante.viewmodel.CreateDishViewModel
import edu.utez.mx.restaurante.viewmodel.CreateUserViewModel
import edu.utez.mx.restaurante.viewmodel.EditDishViewModel
import edu.utez.mx.restaurante.viewmodel.LoginViewModel
import edu.utez.mx.restaurante.viewmodel.PlatilloListViewModel
import edu.utez.mx.restaurante.viewmodel.ViewModelFactory



@Composable
fun Navigation(appContainer: AppContainer) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        //Nuevas rutas aca
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("registeruser"){
            val viewModel: CreateUserViewModel = viewModel()
            CreateUserScreen(viewModel = viewModel ,navController=navController)
        }
        composable("olvcon") {
            val viewModel: ContrasenaViewModel = viewModel() // instancia del ViewModel
            ContrasenaScreen(viewModel = viewModel, navController = navController)
        }
        composable ("createDish") {
            val viewModel: CreateDishViewModel = viewModel(factory = ViewModelFactory(appContainer.platilloRepository))
            CreateDishScreen(viewModel, navController)
        }
        composable(
            "editDish/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) {
            val viewModel: EditDishViewModel = viewModel(factory = ViewModelFactory(appContainer.platilloRepository))
            EditDishScreen(viewModel, navController)
        }

          composable("menu") {
              val viewModel: PlatilloListViewModel = viewModel(factory = ViewModelFactory(appContainer.platilloRepository))
              val items = viewModel.items.collectAsState()
              IndexScreen(

                  platillos = items.value,
                  onAddClick = { navController.navigate("createDish") },
                  onPlatilloClick = { id -> navController.navigate("editDish/$id") },
                  navController = navController
              )
          }

    }
}