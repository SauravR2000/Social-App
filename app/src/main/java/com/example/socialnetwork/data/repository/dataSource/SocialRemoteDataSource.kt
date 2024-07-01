package com.example.socialnetwork.data.repository.dataSource

import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import retrofit2.Response

interface SocialRemoteDataSource {

    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<SuccessResponseModel>

    suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Response<LoginSuccessResponseModel>

    suspend fun getAllPosts(): Response<PostListModel>
}