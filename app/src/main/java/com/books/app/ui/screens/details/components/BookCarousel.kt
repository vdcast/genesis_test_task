package com.books.app.ui.screens.details.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.books.app.domain.models.Book
import com.books.app.ui.AppEvent
import com.books.app.ui.AppUiState
import com.books.app.ui.theme.White20
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookCarousel(
    pagerState: PagerState,
    uiState: AppUiState,
    books: List<Book>,
    onEvent: (AppEvent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val freeFlingBehavior = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(5)
    )

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.settledPage }
            .collect { page ->
                delay(100)
                if (pagerState.targetPage == pagerState.settledPage) {
                    onEvent(AppEvent.SelectBook(books[page].id))
                }
            }
    }

    Column(
        modifier = Modifier
    ) {

        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(200.dp),
            contentPadding = PaddingValues(horizontal = 100.dp),
            flingBehavior = freeFlingBehavior
        ) { page ->
            val pageOffset = (
                    (pagerState.currentPage - page) + pagerState
                        .currentPageOffsetFraction
                    ).absoluteValue

            val scale = lerp(
                start = 0.8f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            )

            Box(
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                    .size(200.dp, 250.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(White20)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = rememberAsyncImagePainter(model = uiState.books[page].coverUrl),
                    contentDescription = uiState.books[page].name,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}