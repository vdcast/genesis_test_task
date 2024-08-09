package com.books.app.data

import com.books.app.data.models.BookDto
import com.books.app.data.models.TopBannerSlideDto
import com.books.app.domain.models.Book
import com.books.app.domain.models.TopBannerSlide

fun BookDto.toBook() = Book(
    id = id,
    name = name,
    author = author,
    summary = summary,
    genre = genre,
    coverUrl = coverUrl,
    views = views,
    likes = likes,
    quotes = quotes
)

fun TopBannerSlideDto.toTopBannerSlide() = TopBannerSlide(
    id = id,
    bookId = bookId,
    cover = cover
)