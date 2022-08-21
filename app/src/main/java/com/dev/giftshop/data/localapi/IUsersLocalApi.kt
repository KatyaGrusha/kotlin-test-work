package com.dev.giftshop.data.localapi

import com.dev.giftshop.data.dataclass.UserModel

interface IUsersLocalApi {
    fun saveUsersList(data: List<UserModel>?)
    fun readUsersList(): List<UserModel>?
    fun getUserByUserID(userId: Int): UserModel?
    fun clear()
}