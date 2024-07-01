package com.example.socialnetwork.data.model.loginSuccessResponseModel


import com.google.gson.annotations.SerializedName

data class LoginSuccessResponseModel(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("uuid")
    val uuid: String
)