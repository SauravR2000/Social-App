package com.example.socialnetwork.data.api

import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SocialApiService {

    @POST("account/register")
    suspend fun registerUser(
        @Body registerUserRequestModel: RegisterUserRequestModel
    ): Response<RegisterUserResponseModel>
}