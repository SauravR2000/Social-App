package com.example.socialnetwork.data.model.refreshTokenRequestModel

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequestModel(
    @SerializedName("refreshToken")
    val refreshToken: String
)