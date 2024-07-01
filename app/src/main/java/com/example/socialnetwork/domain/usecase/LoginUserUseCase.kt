package com.example.socialnetwork.domain.usecase

import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository
import retrofit2.Response

class LoginUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend fun execute(loginUserRequestModel: LoginUserRequestModel): Resource<LoginSuccessResponseModel> {
        return authRepository.loginUser(loginUserRequestModel)
    }
}