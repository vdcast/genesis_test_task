package com.books.app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R

@Composable
fun TextOne(
    text: String,
    color: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = Modifier
            .padding(start = 16.dp),
        text = text,
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        color = color,
        fontSize = fontSize,
        lineHeight = fontSize * 1.1f,
        fontWeight = FontWeight(700)
    )
}

@Composable
fun TextTwo(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        color = color,
        fontSize = fontSize,
        lineHeight = fontSize * 1.1f,
        fontWeight = FontWeight(700),
        letterSpacing = (-0.41).sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun TextThree(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        color = color,
        fontSize = fontSize,
        lineHeight = fontSize * 1.22f,
        fontWeight = FontWeight(700),
        letterSpacing = (-0.41).sp,
    )
}

@Composable
fun TextFour(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        color = color,
        fontSize = fontSize,
        lineHeight = fontSize * 1.2f,
        fontWeight = FontWeight(600),
        letterSpacing = (0.15).sp,
    )
}

@Composable
fun TextFive(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        color = color,
        fontSize = fontSize,
        lineHeight = fontSize,
        fontWeight = FontWeight(800),
    )
}