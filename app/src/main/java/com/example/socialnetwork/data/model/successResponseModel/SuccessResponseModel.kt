package com.example.socialnetwork.data.model.successResponseModel


import com.google.gson.annotations.SerializedName

data class SuccessResponseModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)