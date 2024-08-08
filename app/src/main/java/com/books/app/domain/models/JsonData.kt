package com.books.app.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonData (
    val books: List<Book>,

    @SerialName("top_banner_slides")
    val topBannerSlides: List<TopBannerSlide>,

    @SerialName("you_will_like_section")
    val youWillLikeSection: List<Long>
)