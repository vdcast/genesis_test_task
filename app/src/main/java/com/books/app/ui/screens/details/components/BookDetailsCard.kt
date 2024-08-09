package com.books.app.ui.screens.details.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.books.app.ui.AppUiState
import com.books.app.ui.theme.White100

@Composable
fun BookDetailsCard(
    uiState: AppUiState,
    onYouWillLikeSectionClick: (Long) -> Unit,
) {
    uiState.selectedBook?.let { selectedBook ->
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(White100)
        ) {
            BookStats(selectedBook = selectedBook)
            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDividerOne()
            Spacer(modifier = Modifier.height(24.dp))

            Summary(selectedBook = selectedBook)
            HorizontalDividerOne()
            Spacer(modifier = Modifier.height(16.dp))

            YouWillAlsoLike(uiState = uiState, onYouWillLikeSectionClick = onYouWillLikeSectionClick)
            Spacer(modifier = Modifier.height(32.dp))

            ButtonReadNow()
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}