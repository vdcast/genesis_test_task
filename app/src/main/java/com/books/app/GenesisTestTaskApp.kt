package com.books.app

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.books.app.ui.AppViewModel
import com.books.app.ui.navigation.Routes
import com.books.app.ui.screens.DetailsScreen
import com.books.app.ui.screens.MainScreen
import com.books.app.ui.screens.SplashScreen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GenesisTestTaskApp : Application()

@Composable
fun AppUi(
    viewModel: AppViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(
                onSplashToMain = {
                    navController.navigate(Routes.MainScreen.route)
                }
            )
        }
        composable(Routes.MainScreen.route) {
            MainScreen()
        }
        composable(Routes.DetailsScreen.route) {
            DetailsScreen()
        }
    }
}