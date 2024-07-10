package com.example.socialnetwork.presentation.posts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.noInternetError
import com.example.socialnetwork.constants.somethingWentWrongError
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.domain.usecase.GetAllPostsUseCase
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val getAllPostsUseCase: GetAllPostsUseCase,
) : ViewModel() {

    var homeData = MutableStateFlow<UiState<PostListModel?>>(UiState.INITIAL())



    fun getAllPosts() {

        homeData.tryEmit(UiState.LOADING())

        if (isInternetAvailable(app)) {
            try {
                viewModelScope.launch {
                    val response = getAllPostsUseCase.execute()
                    log("get all posts response = ${response.data}")
                    log("get all posts response = ${response.message}")

                    if (response.data != null) {
                        log("get products success")
                        homeData.tryEmit(UiState.SUCCESS(data = response.data))
                    } else {
                        log("get product error")
                        homeData.tryEmit(
                            UiState.ERROR(
                                response.message ?: "Sorry something went wrong"
                            )
                        )
                    }

                }
            } catch (e: Exception) {
                homeData.tryEmit(
                    UiState.ERROR(
                        somethingWentWrongError(e = e)
                    )
                )
            }
        } else {
            homeData.tryEmit(UiState.ERROR(noInternetError))
        }


    }
}