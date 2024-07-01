package com.example.socialnetwork.data.api

import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SocialApiService {

    @POST("account/register")
    suspend fun registerUser(
        @Body registerUserRequestModel: RegisterUserRequestModel
    ): Response<SuccessResponseModel>

    @POST("account/login")
    suspend fun loginUser(
        @Body loginUserRequestModel: LoginUserRequestModel,
    ): Response<LoginSuccessResponseModel>

    @GET("post")
    suspend fun getAllPosts(): Response<PostListModel>

}