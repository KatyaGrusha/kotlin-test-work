package com.dev.giftshop.data.repository

import com.dev.giftshop.data.dataclass.UserModel
import com.dev.giftshop.data.localapi.IUsersLocalApi
import com.dev.giftshop.data.requester.UsersRequester
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val usersLocalApi: IUsersLocalApi,
    private val usersRequester: UsersRequester
): IUsersRepository {

    override suspend fun sendGetRequestUsers() {
        withContext(Dispatchers.IO){
            val resUsers = async { usersRequester.getUsers() }
                .await()
            usersLocalApi.saveUsersList(resUsers)
        }
    }

    override fun readUsersList(): List<UserModel>? {
        return usersLocalApi.readUsersList()
    }

    override fun getUserByUserID(userId: Int): UserModel? {
        return usersLocalApi.getUserByUserID(userId)
    }
}