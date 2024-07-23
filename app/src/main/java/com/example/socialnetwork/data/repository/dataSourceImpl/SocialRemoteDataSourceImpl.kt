package com.example.socialnetwork.data.repository.dataSourceImpl

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.LoginMutation
import com.example.RegisterMutation
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.model.genericModel.ApiResponse
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
//import com.example.socialnetwork.data.model.loginSuccessResponseModel.toLoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.type.LoginInput
import com.example.type.SingUpInput
import retrofit2.Response
import javax.inject.Inject

class SocialRemoteDataSourceImpl @Inject constructor(
    private val socialApiService: SocialApiService,
    private val apolloClient: ApolloClient,
) : SocialRemoteDataSource {
    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<SuccessResponseModel> {
        return socialApiService.registerUser(registerUserRequestModel)
    }

    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Response<LoginSuccessResponseModel> {
        return socialApiService.loginUser(loginUserRequestModel)
    }

//    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): ApolloResponse<RegisterMutation.Data> {
//
//        val signUpModel = SingUpInput(
//            userName = registerUserRequestModel.userName,
//            repeatPassword = registerUserRequestModel.repeatPassword,
//            email = registerUserRequestModel.email,
//            password = registerUserRequestModel.password,
//        )
//
//        return apolloClient
//            .mutation(RegisterMutation(signUpModel))
//            .execute()
//    }
//
//    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): ApolloResponse<LoginMutation.Data> {
//        val loginInput = LoginInput(
//            email = loginUserRequestModel.email,
//            password = loginUserRequestModel.password,
//        )
//
//        return apolloClient
//            .mutation(LoginMutation(input = loginInput))
//            .execute()
//
//    }

    override suspend fun getAllPosts(): Response<PostListModel> {
        return socialApiService.getAllPosts()
    }

    override suspend fun refreshToken(refreshTokenRequestModel: RefreshTokenRequestModel): Response<RefreshTokenResponseModel> {
        return socialApiService.refreshToken(refreshTokenRequestModel)
    }

    override suspend fun userDetail(userId: String): Response<ApiResponse<UserDetailModel>> {
        return socialApiService.getUserDetail(userId)
    }
}