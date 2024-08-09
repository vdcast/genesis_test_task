package com.books.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonData (
    val books: List<BookDto>,

    @SerialName("top_banner_slides")
    val topBannerSlides: List<TopBannerSlideDto>,

    @SerialName("you_will_like_section")
    val youWillLikeSection: List<Long>
)