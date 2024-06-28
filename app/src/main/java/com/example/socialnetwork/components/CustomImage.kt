//1package com.example.socialnetwork//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun CustomImage(imageUrl: String?) {
//    Box(
//
//        modifier = Modifier
//            .clip(RoundedCornerShape(8.dp))
//            .background(Color.White)
//            .aspectRatio(1f)
//    ) {
//        Image(
//            painter = rememberAsyncImagePainter(
//                imageUrl ?: imageNotFoundUrl,
//                placeholder = painterResource(
//                    R.drawable.ic_launcher_background
//                )
//            ),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f)
//                .height(23.dp)
//                .width(23.dp),
//        )
//    }
//}