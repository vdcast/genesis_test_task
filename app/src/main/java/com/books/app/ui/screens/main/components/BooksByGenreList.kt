package com.books.app.ui.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.domain.models.Book
import com.books.app.ui.components.TextOne
import com.books.app.ui.theme.White100

@Composable
fun BooksByGenreList(
    booksByGenre: Map<String, List<Book>>,
    onBookClick: (Long) -> Unit,
) {
    Column {
        booksByGenre.forEach { (genre, books) ->
            TextOne(text = genre, color = White100, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            BookList(
                books = books,
                onBookClick = onBookClick
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}