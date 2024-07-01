package com.example.socialnetwork.presentation.auth.login

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetwork.constants.accessToken
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.constants.noInternetError
import com.example.socialnetwork.constants.refreshToken
import com.example.socialnetwork.constants.somethingWentWrongError
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.domain.usecase.LoginUserUseCase
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.utils.PreferencesManager
import com.example.socialnetwork.utils.isInternetAvailable
import com.example.socialnetwork.utils.validateEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val app: Application,
    private val loginUserUseCase: LoginUserUseCase,
    private val preferencesManager: PreferencesManager,
) : ViewModel() {
    var loginData = MutableStateFlow<UiState<String>>(UiState.INITIAL())

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    var emailValue by mutableStateOf("")
        private set
    var emailError by mutableStateOf("")
        private set

    fun setEmail(value: String) {
        emailValue = value
    }

    var passwordValue by mutableStateOf("")
        private set
    var passwordError by mutableStateOf("")
        private set

    fun setPassword(value: String) {
        passwordValue = value
    }

    fun validateLoginForm(): Boolean {
        return validateEmail(emailValue)
    }


    fun userLogin() {
        loginData.tryEmit(UiState.LOADING())

        val loginUserRequestModel = LoginUserRequestModel(
            email = emailValue,
            password = passwordValue,
        )

        viewModelScope.launch {
            try {
                if (isInternetAvailable(app)) {
                    val response = loginUserUseCase.execute(loginUserRequestModel)

                    log("login user response = ${response.data?.message ?: ""}")

                    if (response.message != null) {
                        log("error in login = ${response.message}")
                        loginData.tryEmit(UiState.ERROR(response.message ?: ""))
                    } else {
                        log("login success = ${response.data}")

                        preferencesManager.saveData(accessToken, response.data?.accessToken ?: "")
                        preferencesManager.saveData(refreshToken, response.data?.refreshToken ?: "")

                        loginData.tryEmit(UiState.SUCCESS(response.data?.message ?: ""))
                    }

                } else {
                    Log.i(myTag, "no internet")
                    loginData.tryEmit(UiState.ERROR(noInternetError))

                }
            } catch (e: Exception) {
                log("error in user login = ${e.message}")

                loginData.tryEmit(UiState.ERROR(somethingWentWrongError(e)))
            }
        }
    }

}