package com.example.socialnetwork.data.repository.dataSourceImpl

import com.example.socialnetwork.constants.log
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class SocialRemoteDataSourceImpl @Inject constructor(
    private val socialApiService: SocialApiService
) : SocialRemoteDataSource {
    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<SuccessResponseModel> {
        return socialApiService.registerUser(registerUserRequestModel)
    }

    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Response<LoginSuccessResponseModel> {
        return socialApiService.loginUser(loginUserRequestModel)
    }

    override suspend fun getAllPosts(): Response<PostListModel> {
        return socialApiService.getAllPosts()
    }

    override suspend fun refreshtToken(refreshTokenRequestModel: RefreshTokenRequestModel): Response<RefreshTokenResponseModel> {
        return socialApiService.refreshToken(refreshTokenRequestModel)
    }
}