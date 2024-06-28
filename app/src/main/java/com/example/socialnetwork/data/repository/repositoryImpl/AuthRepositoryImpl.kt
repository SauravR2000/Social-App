package com.example.socialnetwork.data.repository.repositoryImpl

import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.registerUserResponseModel.RegisterUserResponseModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val socialRemoteDataSource: SocialRemoteDataSource) :
    AuthRepository {


    private fun responseToResource(response: Response<RegisterUserResponseModel>): Resource<RegisterUserResponseModel> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<RegisterUserResponseModel> {
        return responseToResource(
            socialRemoteDataSource.registerUser(registerUserRequestModel)
        )
    }
}