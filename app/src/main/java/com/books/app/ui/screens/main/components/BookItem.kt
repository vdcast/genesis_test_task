package com.books.app.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.books.app.domain.models.Book
import com.books.app.ui.components.TextTwo
import com.books.app.ui.theme.White70

@Composable
fun BookItem(
    book: Book,
    onBookClick: (Long) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onBookClick(book.id) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = book.coverUrl),
            modifier = Modifier
                .size(140.dp, 175.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = book.name,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextTwo(text = book.name, color = White70, fontSize = 16.sp)
    }
}