package com.example.socialnetwork.data.model.userDetailModel


import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @SerializedName("blockUser")
    val blockUser: Boolean?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("followers")
    val followers: List<Any?>?,
    @SerializedName("following")
    val following: List<Any?>?,
    @SerializedName("googleAuthSecret")
    val googleAuthSecret: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean?,
    @SerializedName("mfaEnabled")
    val mfaEnabled: Boolean?,
    @SerializedName("profile")
    val profile: Profile?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("userName")
    val userName: String?,
    @SerializedName("userPostCount")
    val userPostCount: Int?,
    @SerializedName("__v")
    val v: Int?
)