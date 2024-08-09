package com.books.app.ui

import com.books.app.domain.models.Book
import com.books.app.domain.models.TopBannerSlide

data class AppUiState(
    val books: List<Book> = emptyList(),
    val topBannerSlides: List<TopBannerSlide> = emptyList(),
    val youWillLikeSection: List<Book> = emptyList(),
    val booksByGenre: Map<String, List<Book>> = emptyMap(),
    val selectedBook: Book? = null,
)