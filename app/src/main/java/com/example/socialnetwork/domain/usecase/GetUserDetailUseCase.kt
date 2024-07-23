package com.example.socialnetwork.domain.usecase

import com.example.socialnetwork.data.model.genericModel.ApiResponse
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.UserRepository
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute(userId: String): Resource<ApiResponse<UserDetailModel>> {
        return userRepository.getUserDetail(userId)
    }
}