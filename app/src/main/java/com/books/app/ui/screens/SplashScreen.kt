package com.books.app.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashToMain: () -> Unit,
) {

    LaunchedEffect(Unit) {
        delay(2000)
        onSplashToMain()
    }

    Text(text = "SplashScreen")
}