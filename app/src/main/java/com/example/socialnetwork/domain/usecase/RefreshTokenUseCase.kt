package com.example.socialnetwork.domain.usecase

import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository

class RefreshTokenUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun execute(refreshTokenRequestModel: RefreshTokenRequestModel): Resource<RefreshTokenResponseModel> {
        return authRepository.refreshToken(refreshTokenRequestModel)
    }
}