package com.dev.giftshop.data.network

import com.dev.giftshop.LinkData
import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.data.dataclass.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RestApiService {
    @Headers("Content-Type: application/json")
    @GET(LinkData.USERS_URL)
    suspend fun getUsers(): Response<List<UserModel>>

    @Headers("Content-Type: application/json")
    @GET(LinkData.POSTS_URL)
    suspend fun getPosts(): Response<List<PostModel>>
}