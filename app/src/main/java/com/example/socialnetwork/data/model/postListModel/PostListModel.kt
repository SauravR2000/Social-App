package com.example.socialnetwork.data.model.postListModel


import com.google.gson.annotations.SerializedName

data class PostListModel(
    @SerializedName("data")
    val `data`: List<PostData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)