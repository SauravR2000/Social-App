package com.example.socialnetwork.domain.usecase

import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.util.Resource
import com.example.socialnetwork.domain.repository.PostRepository
import javax.inject.Inject


class GetAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(): Resource<PostListModel> {
        return postRepository.getAllPosts()
    }
}