package com.dev.giftshop.data.repository

import com.dev.giftshop.data.dataclass.UserModel

interface IUsersRepository {
    suspend fun sendGetRequestUsers()
    fun readUsersList(): List<UserModel>?
    fun getUserByUserID(userId: Int): UserModel?
}