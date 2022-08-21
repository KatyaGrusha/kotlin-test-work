package com.dev.giftshop.data.requester

import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.data.network.RestApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class PostsRequester @Inject constructor(
    private val restApiService: RestApiService
) {
    suspend fun getPosts(): List<PostModel>? {
        return withContext(Dispatchers.IO) {
            try {
                val result = restApiService.getPosts()
                if (result.isSuccessful) {
                    result.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                null
            }
        }
    }
}