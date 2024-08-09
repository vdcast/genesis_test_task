package com.books.app

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.books.app.ui.AppViewModel
import com.books.app.ui.navigation.Routes
import com.books.app.ui.screens.details.DetailsScreen
import com.books.app.ui.screens.main.MainScreen
import com.books.app.ui.screens.splash.SplashScreen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application()

@Composable
fun AppUi(
    appViewModel: AppViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by appViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(
                onMainScreenOpen = {
                    navController.navigate(Routes.MainScreen.route) {
                        popUpTo(Routes.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Routes.MainScreen.route) {
            MainScreen(
                uiState = uiState,
                onEvent = appViewModel::onEvent,
                onDetailsScreenOpen = {
                    navController.navigate(Routes.DetailsScreen.route)
                }
            )
        }
        composable(Routes.DetailsScreen.route) {
            DetailsScreen(
                uiState = uiState,
                onEvent = appViewModel::onEvent,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}