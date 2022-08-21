package com.dev.giftshop.data.localapi

import com.dev.giftshop.data.dataclass.PostModel

interface IPostsLocalApi {
    fun savePostsList(data: List<PostModel>?)
    fun readPostsList(): List<PostModel>?
    fun clear()
}