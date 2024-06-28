package com.example.socialnetwork.data.repository.dataSource

import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import retrofit2.Response

interface SocialRemoteDataSource {

    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<RegisterUserResponseModel>
}