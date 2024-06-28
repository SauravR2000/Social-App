package com.example.socialnetwork.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.socialnetwork.ui.theme.YellowDark


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    isLoading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = YellowDark,
        ),
        shape = RoundedCornerShape(25)
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = Color.White)
        } else {
            Text(text, color = Color.White)

        }
    }
}