package com.example.socialnetwork.data.model.refreshTokenResponseModel


import com.google.gson.annotations.SerializedName

data class RefreshTokenResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)