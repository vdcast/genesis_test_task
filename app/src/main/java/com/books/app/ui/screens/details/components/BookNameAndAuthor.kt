package com.books.app.ui.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.books.app.domain.models.Book
import com.books.app.ui.components.TextTwo
import com.books.app.ui.theme.White100
import com.books.app.ui.theme.White80

@Composable
fun BookNameAndAuthor(
    book: Book
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTwo(
            text = book.name,
            color = White100,
            fontSize = 20.sp
        )
        TextTwo(
            text = book.author,
            color = White80,
            fontSize = 14.sp
        )
    }
}