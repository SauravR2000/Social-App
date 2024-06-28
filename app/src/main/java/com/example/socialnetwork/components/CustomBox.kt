package com.example.socialnetwork.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.socialnetwork.constants.buttonColor
import com.example.socialnetwork.constants.mediumTextSize

@Composable
fun CustomBox(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(buttonColor)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = mediumTextSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            ),
            modifier = Modifier.padding(10.dp)
        )
    }
}