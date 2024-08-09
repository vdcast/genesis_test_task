package com.books.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopBannerSlideDto (
    val id: Long,

    @SerialName("book_id")
    val bookId: Long,

    val cover: String
)
