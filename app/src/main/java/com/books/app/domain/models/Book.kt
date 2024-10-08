package com.books.app.domain.models

data class Book(
    val id: Long,
    val name: String,
    val author: String,
    val summary: String,
    val genre: String,
    val coverUrl: String,
    val views: String,
    val likes: String,
    val quotes: String
)