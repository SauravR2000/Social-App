package com.example.socialnetwork.presentation.auth

import android.app.Application
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetwork.constants.noInternetError
import com.example.socialnetwork.constants.somethingWentWrongError
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.domain.usecase.RegisterUserUseCase
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

//@HiltViewModel
class AuthViewModel @Inject constructor(
//    private val app: Application,
//    private val registerUserUseCase: RegisterUserUseCase,
//    private val preferencesManager: PreferencesManager,
//    private val loginUserUseCase: LoginUserUseCase,
//    private val globalViewModel: GlobalViewModel,
) : ViewModel() {

    var loginData = MutableStateFlow<UiState<String>>(UiState.INITIAL())
    var registerData = MutableStateFlow<UiState<String>>(UiState.INITIAL())

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

    var confirmPasswordValue by mutableStateOf("")
        private set
    var confirmPasswordError by mutableStateOf("")
        private set

    fun setConfirmPassword(value: String) {
        confirmPasswordValue = value
    }

    var userNameValue by mutableStateOf("")
        private set
    var userNameError by mutableStateOf("")
        private set

    fun setUserName(value: String) {
        userNameValue = value
    }

    private fun validateEmail(): Boolean {
        val email = emailValue.trim()
        var isValid = true
        var errorMessage = ""
        if (email.isBlank() || email.isEmpty()) {
            errorMessage = "Please fill email field"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage = "Wrong email Format"
            isValid = false
        }
        emailError = errorMessage
        return isValid
    }

    private fun validatePassword(): Boolean {
        val password = passwordValue.trim()
        var isValid = true
        var errorMessage = ""

        if (password.isBlank() || password.isEmpty()) {
            errorMessage = "Please fill password field"
            isValid = false
        } else if (password.length < 6) {
            errorMessage = "Password must more than 6 character"
            isValid = false
        }
        passwordError = errorMessage
        return isValid
    }

    private fun validateUserName(): Boolean {
        val userName = userNameValue.trim()
        var isValid = true
        var errorMessage = ""

        if (userName.isBlank() || userName.isEmpty()) {
            errorMessage = "Please fill user name field"
            isValid = false
        }
        userNameError = errorMessage
        return isValid
    }

    private fun validatePasswordMatch(): Boolean {
        val password = passwordValue.trim()
        val confirmPassword = confirmPasswordValue.trim()
        var isValid = true
        var errorMessage = ""

        if (password != confirmPassword) {
            errorMessage = "Passwords don't match"
            isValid = false
        }

        confirmPasswordError = errorMessage
        return isValid
    }

    fun validateLoginForm(): Boolean {
        return validateEmail() && validatePassword()
    }

    fun validateRegisterForm(): Boolean {
        return validateUserName() && validateEmail() && validatePassword() && validatePasswordMatch()
    }


    fun userLogin() {
        loginData.tryEmit(UiState.LOADING())
        //
//        val loginRequestModel = LoginRequestModel(
//            emailValue,
//            passwordValue,
//        )

//        loginUserUseCase(loginRequestModel).onEach {
//            preferencesManager.saveData("token", it?.token ?: "")
//
//            globalViewModel.checkIsUserLoggedIn()
//
//            loginData.tryEmit(UiState.SUCCESS(it?.token ?: ""))
//        }.catch {
//            println("error while logging in view model = ${it.message}")
//            loginData.tryEmit(UiState.ERROR(it.message ?: "Error whi le logging in"))
//        }.launchIn(viewModelScope)
    }

    fun userRegister() {
        val registerUserRequestModel = RegisterUserRequestModel(
            userName = userNameValue,
            email = emailValue,
            password = passwordValue,
            repeatPassword = confirmPasswordValue,
        )

        viewModelScope.launch {
//            try {
//                if (isInternetAvailable(app)) {
//                    val response = registerUserUseCase.execute(registerUserRequestModel)
//
//                    registerData.tryEmit(UiState.SUCCESS(response.message ?: ""))
//                } else {
//                    registerData.tryEmit(UiState.ERROR(noInternetError))
//
//                }
//            } catch (e: Exception) {
//                registerData.tryEmit(UiState.ERROR(somethingWentWrongError(e)))
//
//            }
        }


    }


}