package com.example.socialnetwork.data.model.postListModel


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("followers")
    val followers: List<Any>,
    @SerializedName("following")
    val following: List<Any>,
    @SerializedName("_id")
    val id: String,
//    @SerializedName("id")
//    val id: String,
    @SerializedName("userName")
    val userName: String
)