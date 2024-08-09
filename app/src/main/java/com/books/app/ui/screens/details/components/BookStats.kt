package com.books.app.ui.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.books.app.R
import com.books.app.domain.models.Book

@Composable
fun BookStats(
    selectedBook: Book
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BookStatsItem(
            modifier = Modifier.weight(1f),
            textUpper = selectedBook.views,
            textLower = stringResource(id = R.string.readers)
        )
        BookStatsItem(
            modifier = Modifier.weight(1f),
            textUpper = selectedBook.likes,
            textLower = stringResource(id = R.string.likes)
        )
        BookStatsItem(
            modifier = Modifier.weight(1f),
            textUpper = selectedBook.quotes,
            textLower = stringResource(id = R.string.quotes)
        )
        BookStatsItem(
            modifier = Modifier.weight(1f),
            textUpper = selectedBook.genre,
            textLower = stringResource(id = R.string.genre)
        )
    }
}