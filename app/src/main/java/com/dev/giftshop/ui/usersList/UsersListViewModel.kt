package com.dev.giftshop.ui.usersList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.giftshop.domain.entity.UserInfoEntity
import com.dev.giftshop.domain.usecases.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {
    private val _userList = MutableLiveData<List<UserInfoEntity>?>()
    val userList: LiveData<List<UserInfoEntity>?>
        get() = _userList

    init {
        viewModelScope.launch {
            _userList.value = usersUseCase.getUsersList()
        }
    }
}