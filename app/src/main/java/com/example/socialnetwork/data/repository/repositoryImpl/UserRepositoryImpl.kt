package com.example.socialnetwork.data.repository.repositoryImpl

import com.example.socialnetwork.data.model.genericModel.ApiResponse
import com.example.socialnetwork.data.model.userDetailModel.UserDetailModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.UserRepository
import com.example.socialnetwork.utils.responseToResource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: SocialRemoteDataSource
) : UserRepository {
    override suspend fun getUserDetail(userId: String): Resource<ApiResponse<UserDetailModel>> {
        return responseToResource(
            remoteDataSource.userDetail(userId)
        )
    }
}