package com.example.socialnetwork.data.model.loginSuccessResponseModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("userName")
    val userName: String
)