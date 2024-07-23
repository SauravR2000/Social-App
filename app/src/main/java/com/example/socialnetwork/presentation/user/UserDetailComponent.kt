package com.example.socialnetwork.presentation.user

import CustomImage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.socialnetwork.R
import com.example.socialnetwork.components.VerticalGapLarge
import com.example.socialnetwork.components.VerticalGapMedium
import com.example.socialnetwork.components.VerticalGapSmall
import com.example.socialnetwork.components.shimmerLoading.ComponentCircle
import com.example.socialnetwork.components.shimmerLoading.ComponentRectangle
import com.example.socialnetwork.components.shimmerLoading.ComponentRectangleLineLong
import com.example.socialnetwork.components.shimmerLoading.ComponentRectangleLineShort
import com.example.socialnetwork.largeTextSize
import com.example.socialnetwork.mediumTextSize
import com.example.socialnetwork.state.UiState

@Composable
fun UserDetailComponent(
    screenHeight: Dp,
    gradientBrush: Brush,
    profileImageRadius: Int,
    profileViewModel: ProfileViewModel
) {

    val state = profileViewModel.state.collectAsState(initial = UiState.LOADING()).value

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight / 3),
        shape = RoundedCornerShape(
            bottomStart = 30.dp,
            bottomEnd = 30.dp
        ),
        color = MaterialTheme.colorScheme.background // Adjust the color if needed
    ) {

        Box(
            modifier = Modifier
                .background(brush = gradientBrush)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.circles),
                contentDescription = "bubble",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                when (state) {
                    is UiState.LOADING -> {
                        ComponentCircle()
                        VerticalGapMedium()
                        ComponentRectangleLineLong()
                        VerticalGapSmall()
                        ComponentRectangleLineShort()
                        VerticalGapSmall()
                    }

                    is UiState.SUCCESS -> {

                        val data = state.data

                        ProfileImage(profileImageRadius)
                        VerticalGapMedium()
                        Text(text = data?.userName ?: "", fontSize = largeTextSize, color = Color.White)
                        Text(text = data?.email ?: "", fontSize = largeTextSize, color = Color.White)
                    }

                    is UiState.ERROR -> {
                        Text(text = state.error.toString())
                    }

                    else -> {
                        Text(text = "Sorry Something Went Wrong")
                    }

                }


            }
        }
    }
}

@Composable
fun ProfileImage(profileImageRadius: Int) {

    Box(
        modifier = Modifier
            .size(profileImageRadius.dp + 10.dp)
            .background(
                color = Color.White,
                shape = CircleShape
            ) // Border background
            .padding(4.dp), // Border width
        contentAlignment = Alignment.Center,
    ) {
        CustomImage(
            imageUrl = "https://file.xunruicms.com/admin_html/assets/pages/media/profile/profile_user.jpg",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .width(profileImageRadius.dp)
                .height(profileImageRadius.dp)
        )


    }

}


