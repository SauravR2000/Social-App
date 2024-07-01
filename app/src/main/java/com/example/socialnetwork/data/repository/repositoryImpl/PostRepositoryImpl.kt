package com.example.socialnetwork.data.repository.repositoryImpl

import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.PostRepository
import com.example.socialnetwork.utils.responseToResource
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: SocialRemoteDataSource
) : PostRepository {
    override suspend fun getAllPosts(): Resource<PostListModel> {
        return responseToResource(
            remoteDataSource.getAllPosts()
        )
    }
}