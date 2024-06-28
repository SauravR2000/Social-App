package com.example.socialnetwork.domain.usecase

import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor (
    private val authRepository: AuthRepository
) {
    suspend fun execute(registerUserRequestModel: RegisterUserRequestModel): Resource<RegisterUserResponseModel> {
        return authRepository.registerUser(registerUserRequestModel)
    }
}