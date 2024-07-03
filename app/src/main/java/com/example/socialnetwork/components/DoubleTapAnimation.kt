package com.example.socialnetwork.components

import CustomImage
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DoubleTapAnimation(
    imageResources: String,
    iconResource: Int,
    size: Dp = 150.dp,
    onDoubleTap: () -> Unit
) {
    var isLike by remember {
        mutableStateOf(false)
    }
    val animatedSize by animateDpAsState(
        targetValue = if (isLike) size else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = 500f // because I like it this way
        )
    )
    Box(modifier = Modifier.fillMaxSize()) {
        CustomImage(
            imageUrl = imageResources, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            isLike = true
                            onDoubleTap()
                        }
                    )
                })
        if (isLike) {
            Icon(
                painterResource(id = iconResource),
                tint = Color.White,
                modifier = Modifier
                    .size(animatedSize)
                    .align(Alignment.Center),
                contentDescription = ""
            )
            if (animatedSize == size) {
                isLike = false
            }
        }
    }
}
