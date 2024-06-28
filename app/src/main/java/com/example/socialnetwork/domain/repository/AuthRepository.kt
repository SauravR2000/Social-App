package com.example.socialnetwork.domain.repository

import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import com.example.socialnetwork.data.util.Resource

interface AuthRepository {

    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<RegisterUserResponseModel>
}