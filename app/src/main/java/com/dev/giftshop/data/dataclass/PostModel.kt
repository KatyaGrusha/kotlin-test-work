package com.dev.giftshop.data.dataclass

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostModel (
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val body: String?
)