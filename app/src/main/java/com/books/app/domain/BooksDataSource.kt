package com.books.app.domain

import com.books.app.domain.models.Book
import com.books.app.domain.models.TopBannerSlide

interface BooksDataSource {
    suspend fun getBooks(): List<Book>
    suspend fun getTopBannerSlides(): List<TopBannerSlide>
    suspend fun getYouWillLikeSection(): List<Long>
}