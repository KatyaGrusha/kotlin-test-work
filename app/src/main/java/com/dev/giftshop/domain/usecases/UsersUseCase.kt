package com.dev.giftshop.domain.usecases

import com.dev.giftshop.data.repository.IPostsRepository
import com.dev.giftshop.data.repository.IUsersRepository
import com.dev.giftshop.domain.entity.UserInfoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val usersRepository: IUsersRepository,
    private val postsRepository: IPostsRepository
) {

    private suspend fun getAllData() {
        withContext(Dispatchers.IO) {
            val resUsers = async { usersRepository.sendGetRequestUsers() }
            val resPosts = async { postsRepository.sendGetRequestPosts() }
            resUsers.await()
            resPosts.await()
        }
    }


    suspend fun getUsersList(): List<UserInfoEntity>? {
        getAllData()
        val listUsers = usersRepository.readUsersList() ?: return null
        val listPosts = postsRepository.readPostsList()
        val userInfoList: MutableList<UserInfoEntity> = mutableListOf()
        listUsers.forEach { item ->
            item.userId?.let {
                userInfoList.add(
                    UserInfoEntity(
                        item.userId,
                        item.thumbnailUrl ?: "",
                        item.name ?: "",
                        listPosts?.filter { it.userId == item.userId }?.size?.toString() ?: "0"
                    )
                )
            }
        }
        return userInfoList
    }
}