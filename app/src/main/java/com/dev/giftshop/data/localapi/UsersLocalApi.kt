package com.dev.giftshop.data.localapi

import com.dev.giftshop.data.dataclass.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersLocalApi @Inject constructor() : IUsersLocalApi{
    private var _usersList: Set<UserModel>? = null

    override fun saveUsersList(data: List<UserModel>?) {
        _usersList = data?.toSet()
    }

    override fun readUsersList(): List<UserModel>? {
        return _usersList?.toList()
    }

    override fun getUserByUserID(userId: Int): UserModel?{
        return _usersList?.find { it.userId == userId }
    }

    override fun clear() {
        _usersList = null
    }
}