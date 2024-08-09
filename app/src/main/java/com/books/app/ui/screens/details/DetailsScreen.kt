package com.books.app.ui.screens.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.books.app.ui.AppEvent
import com.books.app.ui.AppUiState
import com.books.app.ui.screens.details.components.ArrowBack
import com.books.app.ui.screens.details.components.BackgroundImage
import com.books.app.ui.screens.details.components.BookCarousel
import com.books.app.ui.screens.details.components.BookDetailsCard
import com.books.app.ui.screens.details.components.BookDetailsCardRoundedTop
import com.books.app.ui.screens.details.components.BookNameAndAuthor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsScreen(
    uiState: AppUiState,
    onEvent: (AppEvent) -> Unit,
    onBackClick: () -> Unit
) {
    val verticalScrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val localDensity = LocalDensity.current
    val pagerState = rememberPagerState(
        pageCount = { uiState.books.size },
        initialPage = uiState.selectedBook?.id?.toInt() ?: 0
    )
    var contentHeight by remember { mutableStateOf(0.dp) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScrollState)
    ) {
        Box {
            BackgroundImage(height = contentHeight)
            Column(
                modifier = Modifier
                    .onGloballyPositioned { coord ->
                        contentHeight = with(localDensity) { coord.size.height.toDp() }
                    }
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                ArrowBack(onClick = onBackClick)
                Spacer(modifier = Modifier.height(8.dp))

                BookCarousel(
                    pagerState = pagerState,
                    uiState = uiState,
                    onEvent = onEvent,
                    books = uiState.books
                )
                Spacer(modifier = Modifier.height(12.dp))

                uiState.selectedBook?.let { selectedBook ->
                    BookNameAndAuthor(book = selectedBook)
                }
                Spacer(modifier = Modifier.height(16.dp))

                BookDetailsCardRoundedTop()
            }
        }
        BookDetailsCard(
            uiState = uiState,
            onYouWillLikeSectionClick = {
                onEvent(AppEvent.SelectBook(it))
                coroutineScope.launch {
                    launch {
                        verticalScrollState.animateScrollTo(0)
                    }
                    launch {
                        pagerState.animateScrollToPage(it.toInt())
                    }
                }
            }
        )
    }
}