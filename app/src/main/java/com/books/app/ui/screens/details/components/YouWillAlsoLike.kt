package com.books.app.ui.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.books.app.R
import com.books.app.ui.AppUiState
import com.books.app.ui.components.TextTwo
import com.books.app.ui.theme.Black101
import com.books.app.ui.theme.Black102

@Composable
fun YouWillAlsoLike(
    uiState: AppUiState,
    onYouWillLikeSectionClick: (Long) -> Unit
) {
    TextTwo(
        modifier = Modifier.padding(start = 16.dp),
        text = stringResource(id = R.string.you_will_also_like),
        color = Black101,
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(16.dp))

    LazyRow {
        item {
            Spacer(modifier = Modifier.width(16.dp))
        }
        items(uiState.youWillLikeSection) { book ->
            Column(
                modifier = Modifier
                    .width(140.dp)
                    .clickable { onYouWillLikeSectionClick(book.id) }
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
                TextTwo(text = book.name, color = Black102, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
        item {
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}