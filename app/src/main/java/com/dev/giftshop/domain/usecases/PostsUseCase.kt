package com.dev.giftshop.domain.usecases

import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.data.repository.IPostsRepository
import com.dev.giftshop.data.repository.IUsersRepository
import javax.inject.Inject

class PostsUseCase @Inject constructor(
    private val postsRepository: IPostsRepository,
    private val usersRepository: IUsersRepository
) {
    fun getPostsList(userId: Int?): List<PostModel>? {
        if (userId == null) return null
        return postsRepository.getAllPostsByUserId(userId)
    }

    fun getImageUser(userId: Int?): String{
        if (userId == null) return ""
        return usersRepository.getUserByUserID(userId)?.url ?: ""
    }
}