package com.books.app.ui.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.books.app.ui.components.TextThree
import com.books.app.ui.components.TextTwo
import com.books.app.ui.theme.Black101
import com.books.app.ui.theme.Gray101

@Composable
fun BookStatsItem(
    modifier: Modifier = Modifier,
    textUpper: String,
    textLower: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextThree(text = textUpper, color = Black101, fontSize = 18.sp)
        TextTwo(text = textLower, color = Gray101, fontSize = 12.sp)
    }
}