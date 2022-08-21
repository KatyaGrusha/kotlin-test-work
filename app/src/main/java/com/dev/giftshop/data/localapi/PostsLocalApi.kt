package com.dev.giftshop.data.localapi

import com.dev.giftshop.data.dataclass.PostModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsLocalApi @Inject constructor() : IPostsLocalApi {
    private var _postsList: Set<PostModel>? = null

    override fun savePostsList(data: List<PostModel>?) {
        _postsList = data?.toSet()
    }

    override fun readPostsList(): List<PostModel>? {
        return _postsList?.toList()
    }

    override fun clear() {
        _postsList = null
    }
}