package com.example.socialnetwork.presentation.posts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.domain.usecase.GetAllPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val getAllPostsUseCase: GetAllPostsUseCase,
) : ViewModel() {
    fun getAllPosts() {
        viewModelScope.launch {
            val response = getAllPostsUseCase.execute()
            log("get all posts response = ${response.data}")
            log("get all posts response = ${response.message}")
        }
    }
}