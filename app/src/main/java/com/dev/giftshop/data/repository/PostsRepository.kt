package com.dev.giftshop.data.repository

import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.data.localapi.IPostsLocalApi
import com.dev.giftshop.data.requester.PostsRequester
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepository @Inject constructor(
    private val postsLocalApi: IPostsLocalApi,
    private val postsRequester: PostsRequester
): IPostsRepository {

    override suspend fun sendGetRequestPosts() {
        withContext(Dispatchers.IO){
            val resUsers = async { postsRequester.getPosts() }
                .await()
            postsLocalApi.savePostsList(resUsers)
        }
    }

    override fun readPostsList(): List<PostModel>? {
        return postsLocalApi.readPostsList()
    }

    override fun getAllPostsByUserId(userId: Int): List<PostModel>?{
        val list = postsLocalApi.readPostsList() ?: return null
        return list.filter { it.userId == userId }
    }
}