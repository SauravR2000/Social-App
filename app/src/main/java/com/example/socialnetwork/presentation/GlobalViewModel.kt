package com.example.socialnetwork.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.socialnetwork.utils.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import com.example.socialnetwork.constants.accessToken


@HiltViewModel
class GlobalViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    private val _isLoggedIn = mutableStateOf(false)
    val isLoggedIn: State<Boolean> = _isLoggedIn

    private val _showAlertDialog = mutableStateOf(false)
    val showAlertDialog: State<Boolean> = _showAlertDialog

    val snackBarMessage = mutableStateOf("")

    init {
        checkIsUserLoggedIn()
    }

    private fun checkIsUserLoggedIn() {
        val token = preferencesManager.getData(accessToken, "")

        _isLoggedIn.value = token.isNotEmpty()
    }

    fun logOutUser() {
        preferencesManager.saveData(accessToken, "")

        _isLoggedIn.value = false
    }

    fun enableAlertDialog(message: String) {
        _showAlertDialog.value = true
        snackBarMessage.value = message
    }

    fun disableAlertDialog() {
        _showAlertDialog.value = false
    }
}