package com.dev.giftshop.data.dataclass

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserModel(
    val albumId: Int?,
    val userId: Int?,
    val name: String?,
    val url: String?,
    val thumbnailUrl: String?
)
