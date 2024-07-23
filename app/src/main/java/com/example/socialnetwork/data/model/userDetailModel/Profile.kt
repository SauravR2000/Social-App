package com.example.socialnetwork.data.model.userDetailModel


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("avatar")
    val avatar: Any?,
    @SerializedName("bio")
    val bio: Any?,
    @SerializedName("hobbies")
    val hobbies: List<Any?>?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("user")
    val user: String?
)