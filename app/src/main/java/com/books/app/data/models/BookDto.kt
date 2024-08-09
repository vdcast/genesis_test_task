package com.books.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDto (
    val id: Long,
    val name: String,
    val author: String,
    val summary: String,
    val genre: String,

    @SerialName("cover_url")
    val coverUrl: String,

    val views: String,
    val likes: String,
    val quotes: String
)

