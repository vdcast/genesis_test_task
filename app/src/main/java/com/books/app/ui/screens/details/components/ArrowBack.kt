package com.books.app.ui.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.books.app.R

@Composable
fun ArrowBack(
    onClick: () -> Unit
) {
    Image(
        modifier = Modifier
            .padding(start = 16.dp)
            .size(24.dp)
            .clickable {
                onClick()
            },
        painter = painterResource(id = R.drawable.arrow_back),
        contentDescription = "Back"
    )
}