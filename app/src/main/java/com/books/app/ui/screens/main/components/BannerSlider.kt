package com.books.app.ui.screens.main.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.books.app.domain.models.TopBannerSlide
import com.books.app.ui.theme.Gray100
import com.books.app.ui.theme.Pink101
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerSlider(
    slides: List<TopBannerSlide>,
    onBannerClick: (Long) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        slides.size
    })

    val scrollModifier = Modifier.pointerInput(Unit) {
        detectHorizontalDragGestures { change, dragAmount ->
            change.consume()
            when {
                dragAmount < 0 -> {
                    coroutineScope.launch { /* right */
                        if (pagerState.currentPage == slides.lastIndex) {
                            pagerState.animateScrollToPage(0)
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
                dragAmount > 0 -> { /* left */
                    coroutineScope.launch {
                        if (pagerState.currentPage == 0) {
                            pagerState.animateScrollToPage(slides.lastIndex)
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
            while (true) {
                delay(3000)
                val nextPage =
                    if (pagerState.currentPage == slides.size - 1) 0 else pagerState.currentPage + 1
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
                )
            }
    }

    Box {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()

        ) { page ->
            val slide = slides[page]
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(343f / 160f)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        onBannerClick(slide.bookId)
                    }
                    .then(scrollModifier),
                painter = rememberAsyncImagePainter(slide.cover),
                contentDescription = "slider image",
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                for (page in slides.indices) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(8.dp)
                            .background(
                                if (page == pagerState.currentPage) Pink101 else Gray100,
                                shape = RoundedCornerShape(50)
                            )
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page)
                                }
                            }
                    )
                }
            }
        }
    }
}