package com.example.socialnetwork.data.model.postListModel


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
//    @SerializedName("id")
//    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("__v")
    val v: Int
)