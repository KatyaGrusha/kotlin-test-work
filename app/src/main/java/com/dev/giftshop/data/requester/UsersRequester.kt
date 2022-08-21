package com.dev.giftshop.data.requester

import com.dev.giftshop.data.dataclass.UserModel
import com.dev.giftshop.data.network.RestApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class UsersRequester @Inject constructor(
    private val restApiService: RestApiService
) {
    suspend fun getUsers(): List<UserModel>? {
        return withContext(Dispatchers.IO) {
            try {
                val result = restApiService.getUsers()
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