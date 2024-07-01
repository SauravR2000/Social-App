package com.example.socialnetwork.domain.repository

import com.example.socialnetwork.data.model.postListModel.PostListModel
import com.example.socialnetwork.data.util.Resource

interface PostRepository {
    suspend fun getAllPosts() : Resource<PostListModel>
}