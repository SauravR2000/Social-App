package com.example.socialnetwork.data.model.loginUserRequesetModel


import com.google.gson.annotations.SerializedName

data class LoginUserRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)