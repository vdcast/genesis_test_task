package com.books.app.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopBannerSlide (
    val id: Long,

    @SerialName("book_id")
    val bookID: Long,

    val cover: String
)
