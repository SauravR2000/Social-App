package com.example.socialnetwork.domain.repository

import com.example.socialnetwork.data.model.genericModel.ApiResponse
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import com.example.socialnetwork.data.util.Resource

interface UserRepository {
    suspend fun getUserDetail(userId: String): Resource<ApiResponse<UserDetailModel>>
}