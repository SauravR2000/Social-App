package com.example.socialnetwork.presentation.posts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.VerticalGapMedium
import com.example.socialnetwork.data.model.postListModel.PostData
import com.example.socialnetwork.data.model.postListModel.PostListModel


@Composable
fun PostsListView(
    navHostController: NavHostController,
    postListModel: PostListModel,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(postListModel.data.size) { index ->

            val post: PostData = postListModel.data[index]

            PostCard(postData = post)
            VerticalGapMedium()

        }
    }
}