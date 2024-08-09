package com.books.app.ui.screens.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.ui.components.TextFive
import com.books.app.ui.theme.Pink100
import com.books.app.ui.theme.White100

@Composable
fun ButtonReadNow() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(278.dp, 48.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Pink100)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            TextFive(
                text = stringResource(id = R.string.read_now),
                color = White100,
                fontSize = 16.sp
            )
        }
    }
}