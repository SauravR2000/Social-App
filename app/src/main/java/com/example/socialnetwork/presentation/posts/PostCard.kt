package com.example.socialnetwork.presentation.posts

import CustomImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.socialnetwork.R
import com.example.socialnetwork.components.DoubleTapAnimation
import com.example.socialnetwork.components.HorizontalGapSmall
import com.example.socialnetwork.components.HorizontalGapVerySmall
import com.example.socialnetwork.components.VerticalGapSmall
import com.example.socialnetwork.constants.customModifier
import com.example.socialnetwork.constants.smallTextSize
import com.example.socialnetwork.data.model.postListModel.PostData
import com.example.socialnetwork.mediumTextSize


@Composable
fun PostCard(
    postData: PostData,
) {
    Column {
        Text(
            text = postData.user.userName,
            fontSize = mediumTextSize,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = customModifier
        )
        VerticalGapSmall()
//        CustomImage(imageUrl = "https://tse1.mm.bing.net/th/id/OET.7252da000e8341b2ba1fb61c275c1f30?w=594&h=594&c=7&rs=1&o=5&pid=1.9")
        DoubleTapAnimation(
            imageResources = "https://tse1.mm.bing.net/th/id/OET.7252da000e8341b2ba1fb61c275c1f30?w=594&h=594&c=7&rs=1&o=5&pid=1.9",
            iconResource = R.drawable.baseline_favorite_24,
        ) {

        }
        VerticalGapSmall()
        Row(modifier = customModifier, verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = "Heart Icon",
                tint = Color.Red,
                modifier = Modifier.size(28.dp)
            )
            HorizontalGapVerySmall()
            Text(text = postData.likeCount.toString(), fontSize = smallTextSize)
            HorizontalGapSmall()
            Icon(
                imageVector = Icons.Filled.ChatBubbleOutline,
                contentDescription = "Comment",
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
            HorizontalGapVerySmall()
            Text(text = postData.commentCount.toString(), fontSize = smallTextSize)
        }
        VerticalGapSmall()
        Text(
            text = postData.title,
            modifier = customModifier,
            fontSize = mediumTextSize,
            fontWeight = FontWeight.SemiBold,
        )
    }
}