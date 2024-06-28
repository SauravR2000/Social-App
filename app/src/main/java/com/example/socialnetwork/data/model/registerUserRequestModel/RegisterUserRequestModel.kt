package com.example.socialnetwork.data.model.registerUserRequestModel


import com.google.gson.annotations.SerializedName

data class RegisterUserRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("repeat_password")
    val repeatPassword: String,
    @SerializedName("userName")
    val userName: String
)