package com.books.app.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.ui.AppEvent
import com.books.app.ui.AppUiState
import com.books.app.ui.components.TextTwo
import com.books.app.ui.screens.main.components.BannerSlider
import com.books.app.ui.screens.main.components.BooksByGenreList
import com.books.app.ui.theme.Black100
import com.books.app.ui.theme.Pink101

@Composable
fun MainScreen(
    uiState: AppUiState,
    onEvent: (AppEvent) -> Unit,
    onDetailsScreenOpen: () -> Unit,
) {
    val verticalScrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black100)
            .verticalScroll(verticalScrollState),
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        TextTwo(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.library),
            color = Pink101,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (uiState.topBannerSlides.isNotEmpty()) {
            BannerSlider(
                uiState.topBannerSlides,
                onBannerClick = {
                    onEvent(AppEvent.SelectBook(it))
                    onDetailsScreenOpen()
                }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        BooksByGenreList(
            booksByGenre = uiState.booksByGenre,
            onBookClick = {
                onEvent(AppEvent.SelectBook(it))
                onDetailsScreenOpen()
            }
        )
        Spacer(modifier = Modifier.height(64.dp))
    }
}


