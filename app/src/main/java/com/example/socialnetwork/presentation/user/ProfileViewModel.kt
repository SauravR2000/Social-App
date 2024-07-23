package com.example.socialnetwork.presentation.user

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.noInternetError
import com.example.socialnetwork.constants.userId
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import com.example.socialnetwork.domain.usecase.GetUserDetailUseCase
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.utils.PreferencesManager
import com.example.socialnetwork.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserDetailUseCase: GetUserDetailUseCase,
    private val app: Application,
    private val preferencesManager: PreferencesManager,
) : ViewModel() {
    var state = MutableStateFlow<UiState<UserDetailModel?>>(UiState.INITIAL())

    fun getUserDetail() {

        state.tryEmit(UiState.LOADING())

        if (isInternetAvailable(app)) {
            try {
                val userId: String = preferencesManager.getData(userId, "")

                log("userId = $userId")

                viewModelScope.launch {
                    val response = getUserDetailUseCase.execute(userId)

                    log("user detail response = $response")


                    if (response.data != null) {
                        state.tryEmit(
                            UiState.SUCCESS(
                                data = response.data.data
                            )
                        )

                    } else {
                        log("get user detail error ")
                        state.tryEmit(
                            UiState.ERROR(
                                response.message ?: "Sorry something went wrong"
                            )
                        )
                    }

                }
            } catch (e: Exception) {
                log("user detail error response = ${e.message}")

            }

        } else {
            state.tryEmit(UiState.ERROR(noInternetError))
        }
    }


}