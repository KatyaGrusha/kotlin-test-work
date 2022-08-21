package com.dev.giftshop.ui.userDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.domain.usecases.PostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailScreenViewModel @Inject constructor(
    private val postsUseCase: PostsUseCase
) : ViewModel() {
    private val _userPosts = MutableLiveData<List<PostModel>?>()
    val userPosts: LiveData<List<PostModel>?>
        get() = _userPosts

    private val _userImage = MutableLiveData<String>()
    val userImage: LiveData<String>
        get() = _userImage

    fun init(userId: Int?) {
        initList(userId)
        initImage(userId)
    }

    private fun initImage(userId: Int?) {
        viewModelScope.launch {
            _userImage.value = postsUseCase.getImageUser(userId)
        }
    }

    private fun initList(userId: Int?) {
        viewModelScope.launch {
            _userPosts.value = postsUseCase.getPostsList(userId)
        }
    }
}