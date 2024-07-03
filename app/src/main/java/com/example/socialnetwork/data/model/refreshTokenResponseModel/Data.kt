package com.example.socialnetwork.data.model.refreshTokenResponseModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("accessToken")
    val accessToken: String
)