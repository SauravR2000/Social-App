package com.example.socialnetwork.data.repository.dataSourceImpl

import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class SocialRemoteDataSourceImpl @Inject constructor(
    private val socialApiService: SocialApiService
) : SocialRemoteDataSource {
    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Response<RegisterUserResponseModel> {
        return socialApiService.registerUser(registerUserRequestModel)
    }
}