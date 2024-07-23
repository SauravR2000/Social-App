package com.example.socialnetwork.data.api

import com.example.socialnetwork.data.model.genericModel.ApiResponse
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @POST("account/token/refresh")
    suspend fun refreshToken(@Body refreshTokenRequestModel: RefreshTokenRequestModel): Response<RefreshTokenResponseModel>

    @GET("user/{userId}")
    suspend fun getUserDetail(@Path("userId") userId: String): Response<ApiResponse<UserDetailModel>>
}