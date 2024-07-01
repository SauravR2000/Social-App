package com.example.socialnetwork.domain.repository

import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.util.Resource

interface AuthRepository {

    suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<SuccessResponseModel>

    suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Resource<LoginSuccessResponseModel>
}