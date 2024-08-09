package com.books.app.ui.screens.main.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.books.app.domain.models.Book

@Composable
fun BookList(
    books: List<Book>,
    onBookClick: (Long) -> Unit,
) {
    LazyRow {
        item {
            Spacer(modifier = Modifier.width(16.dp))
        }
        items(books) { book ->
            BookItem(
                book = book,
                onBookClick = onBookClick
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        item {
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}