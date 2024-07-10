package com.example.socialnetwork.data.repository.dataSource

import com.apollographql.apollo3.api.ApolloResponse
import com.example.LoginMutation
import com.example.RegisterMutation
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import retrofit2.Response

interface SocialRemoteDataSource {

//    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<SuccessResponseModel>
    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): ApolloResponse<RegisterMutation.Data>

    //    suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Response<LoginSuccessResponseModel>
    suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): ApolloResponse<LoginMutation.Data>

    suspend fun getAllPosts(): Response<PostListModel>

    suspend fun refreshtToken(refreshTokenRequestModel: RefreshTokenRequestModel): Response<RefreshTokenResponseModel>
}