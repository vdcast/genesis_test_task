package com.books.app.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book (
    val id: Long,
    val name: String,
    val author: String,
    val summary: String,
    val genre: String,

    @SerialName("cover_url")
    val coverURL: String,

    val views: String,
    val likes: String,
    val quotes: String
)

