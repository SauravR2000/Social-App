package com.example.socialnetwork.data.model.registerUserResponseModel


import com.google.gson.annotations.SerializedName

data class RegisterUserResponseModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)