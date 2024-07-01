package com.example.socialnetwork.utils

import android.util.Patterns

 fun validateEmail(emailValue : String): Boolean {
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
//    emailError = errorMessage
    return isValid
}

