package com.books.app.domain.remote

import com.books.app.data.models.BookDto
import com.books.app.data.models.TopBannerSlideDto

interface BooksDataSource {
    suspend fun getBooks(): List<BookDto>
    suspend fun getTopBannerSlides(): List<TopBannerSlideDto>
    suspend fun getYouWillLikeSection(): List<Long>
}