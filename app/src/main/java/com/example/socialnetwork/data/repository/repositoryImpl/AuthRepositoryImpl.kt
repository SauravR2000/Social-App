package com.example.socialnetwork.data.repository.repositoryImpl

import android.util.Log
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.data.model.loginSuccessResponseModel.LoginSuccessResponseModel
import com.example.socialnetwork.data.model.loginUserRequesetModel.LoginUserRequestModel
import com.example.socialnetwork.data.model.registerUserRequestModel.RegisterUserRequestModel
import com.example.socialnetwork.data.model.successResponseModel.SuccessResponseModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.utils.responseToResource
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val socialRemoteDataSource: SocialRemoteDataSource) :
    AuthRepository {


//    private fun responseToResource(response: Response<SuccessResponseModel>): Resource<SuccessResponseModel> {
//        if (response.isSuccessful) {
//            response.body()?.let { result ->
//                Log.i(myTag, "success message = ${result}")
//                return Resource.Success(result)
//            }
//        }
//        val jsonObj = JSONObject(response.errorBody()?.string() ?: "")
//        val errorMessage: String? = jsonObj.getString("errors")
//
//        Log.i(myTag, "error = $errorMessage")
//
//
//        return Resource.Error(
//            errorMessage ?: "Something Went Wrong"
//        )
//    }





    override suspend fun registerUser(registerUserRequestModel: RegisterUserRequestModel): Resource<SuccessResponseModel> {
        return responseToResource(
            socialRemoteDataSource.registerUser(registerUserRequestModel)
        )
    }

    override suspend fun loginUser(loginUserRequestModel: LoginUserRequestModel): Resource<LoginSuccessResponseModel> {
        return responseToResource(
            socialRemoteDataSource.loginUser(loginUserRequestModel)
        )
    }
}