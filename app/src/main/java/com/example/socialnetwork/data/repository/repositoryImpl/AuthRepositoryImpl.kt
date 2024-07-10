package com.example.socialnetwork.data.repository.repositoryImpl

import android.util.Log
import com.example.LoginMutation
import com.example.RegisterMutation
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.data.model.refreshTokenResponseModel.RefreshTokenResponseModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.utils.apolloResponseToResource
import com.example.socialnetwork.utils.responseToResource
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val socialRemoteDataSource: SocialRemoteDataSource) :
    AuthRepository {

//    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<SuccessResponseModel> {
//        return responseToResource(
//            socialRemoteDataSource.registerUser(registerUserRequestModel)
//        )
//    }

    //    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Resource<LoginSuccessResponseModel> {
//        return responseToResource(
//            socialRemoteDataSource.loginUser(loginUserRequestModel)
//        )
//    }


    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<RegisterMutation.Data> {
        return apolloResponseToResource(
            socialRemoteDataSource.registerUser(registerUserRequestModel)
        )
    }

    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Resource<LoginMutation.Data> {
//        return responseToResource(
//            socialRemoteDataSource.loginUser(loginUserRequestModel)
//        )

        return apolloResponseToResource(
            socialRemoteDataSource.loginUser(loginUserRequestModel)
        )

    }

    override suspend fun refreshToken(refreshTokenRequestModel: RefreshTokenRequestModel): Resource<RefreshTokenResponseModel> {
        return responseToResource(
            socialRemoteDataSource.refreshtToken(refreshTokenRequestModel)
        )
    }
}