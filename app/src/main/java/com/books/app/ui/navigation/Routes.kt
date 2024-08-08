package com.books.app.ui.navigation

sealed class Routes(val route: String) {
    object SplashScreen : Routes("SplashScreen")
    object MainScreen : Routes("MainScreen")
    object DetailsScreen : Routes("DetailsScreen")
}