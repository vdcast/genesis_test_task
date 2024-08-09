package com.books.app.ui.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.books.app.R
import com.books.app.ui.theme.Black70
import com.books.app.ui.theme.Purple100

@Composable
fun BackgroundImage(
    height: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple100)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x140D14).copy(alpha = 0f),
                            Color(0x302A31).copy(alpha = 0.85f),
                            Color(0x000000).copy(alpha = 0.98f),
                            Color(0x000000).copy(alpha = 0f)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Image(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = 0.6f // Встановлює прозорість 60%
                },
            painter = painterResource(id = R.drawable.details_bg_image_10),
            contentDescription = "details_bg_image_10",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black70)
        )
    }
}