package com.dev.giftshop.data.repository

import com.dev.giftshop.data.dataclass.PostModel

interface IPostsRepository {
    suspend fun sendGetRequestPosts()
    fun readPostsList(): List<PostModel>?
    fun getAllPostsByUserId(userId: Int): List<PostModel>?
}