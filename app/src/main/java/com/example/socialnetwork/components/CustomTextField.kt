package com.example.socialnetwork.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.socialnetwork.constants.smallTextSize
import com.example.socialnetwork.ui.theme.Yellow


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onChange: (String) -> Unit,
    isError: Boolean,
    icon: ImageVector?,
    errorMessage: String,
    isPassword: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    var showPassword by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { if (!it.contains("\n")) onChange(it) },
            placeholder = {
                Text(text = placeholder, style = TextStyle(fontSize = smallTextSize))
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            leadingIcon = if (icon != null) {
                {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Text FieldInput",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp),
                    )

                }
            } else null,
            trailingIcon = {
                if (isPassword) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.VisibilityOff
                        else Icons.Default.Visibility,
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                showPassword = !showPassword
                            },
                        contentDescription = if (showPassword) "Show Password" else "Hide Password",
                    )
                } else {
                    null
                }
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.Black,
                focusedBorderColor = Yellow,
                errorBorderColor = Color.Red,
            ),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (isPassword) {
                if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            isError = isError
        )
        if (isError) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 2.dp),
                textAlign = TextAlign.Start,
            )
        }

    }
}