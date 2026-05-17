package com.example.nammashasane.ui.theme.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nammashasane.ui.theme.screens.CameraScreen
import com.example.nammashasane.ui.theme.screens.HomeScreen
import com.example.nammashasane.ui.theme.screens.MapScreen
import com.example.nammashasane.ui.theme.screens.ProfileScreen
import com.example.nammashasane.ui.theme.screens.LoginScreen
import com.example.nammashasane.ui.theme.screens.SignUpScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("home") {

            HomeScreen(navController)
        }

        composable("map") {

            MapScreen()
        }

        composable("camera") {

            CameraScreen()
        }

        composable("profile") {

            ProfileScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("signup") {
            SignUpScreen(navController)
        }
    }
}
