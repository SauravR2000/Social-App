package com.example.socialnetwork.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalGapSmall() {
    Box(modifier = Modifier.height(10.dp))
}

@Composable
fun VerticalGapMedium() {
    Box(modifier = Modifier.height(15.dp))
}

@Composable
fun VerticalGapLarge() {
    Box(modifier = Modifier.height(20.dp))
}

@Composable
fun HorizontalGapSmall() {
    Box(modifier = Modifier.width(10.dp))
}

@Composable
fun HorizontalGapMedium() {
    Box(modifier = Modifier.width(15.dp))
}

@Composable
fun HorizontalGapLarge() {
    Box(modifier = Modifier.width(20.dp))
}