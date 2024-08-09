package com.books.app.ui.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.domain.models.Book
import com.books.app.ui.components.TextFour
import com.books.app.ui.components.TextTwo
import com.books.app.ui.theme.Black101
import com.books.app.ui.theme.Black102

@Composable
fun Summary(
    selectedBook: Book
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        TextTwo(
            text = stringResource(id = R.string.summary),
            color = Black101,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextFour(text = selectedBook.summary, color = Black102, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(12.dp))
    }
}