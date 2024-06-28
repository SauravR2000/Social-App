package com.example.socialnetwork.presentation.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.CustomButton
import com.example.socialnetwork.components.CustomTextField
import com.example.socialnetwork.components.VerticalGapMedium
import com.example.socialnetwork.components.VerticalGapSmall
import com.example.socialnetwork.constants.backgroundColor
import com.example.socialnetwork.constants.largeTextSize
import com.example.socialnetwork.constants.screenPadding
import com.example.socialnetwork.constants.smallTextSize
import com.example.socialnetwork.navigation.Screens
import com.example.socialnetwork.presentation.auth.AuthViewModel
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.ui.theme.YellowDark


@Composable
fun RegisterScreen(
    navHostController: NavHostController,
    loginViewModel: AuthViewModel,
) {

    val focusManager = LocalFocusManager.current


    //state
    val uiState = loginViewModel.registerData.collectAsState().value


    //UI
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColor))
            .padding(horizontal = screenPadding)
    )
    {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))

                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .padding(18.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Register",
                    style = TextStyle(fontSize = largeTextSize, fontWeight = FontWeight.Bold)
                )
                VerticalGapMedium()
                CustomTextField(
                    value = loginViewModel.userNameValue,
                    placeholder = "User Name",
                    onChange = loginViewModel::setUserName,
                    isError = loginViewModel.userNameError.isNotEmpty(),
                    icon = Icons.Rounded.Person,
                    errorMessage = loginViewModel.userNameError,
                    modifier = Modifier
                )
                VerticalGapMedium()
                CustomTextField(
                    value = loginViewModel.emailValue,
                    placeholder = "Email",
                    onChange = loginViewModel::setEmail,
                    isError = loginViewModel.emailError.isNotEmpty(),
                    icon = Icons.Rounded.Email,
                    errorMessage = loginViewModel.emailError,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier

                )
                VerticalGapMedium()
                CustomTextField(
                    value = loginViewModel.passwordValue,
                    onChange = loginViewModel::setPassword,
                    placeholder = "Password",
                    isError = loginViewModel.passwordError.isNotEmpty(),
                    icon = Icons.Rounded.Password,
                    isPassword = true,
                    errorMessage = loginViewModel.passwordError,
                    modifier = Modifier
                )
                VerticalGapSmall()
                CustomTextField(
                    value = loginViewModel.confirmPasswordValue,
                    onChange = loginViewModel::setConfirmPassword,
                    placeholder = "Confirm Password",
                    isError = loginViewModel.confirmPasswordError.isNotEmpty(),
                    icon = Icons.Rounded.Password,
                    isPassword = true,
                    errorMessage = loginViewModel.confirmPasswordError,
                    modifier = Modifier
                )
                VerticalGapSmall()



                CustomButton(
//                    isEnabled = state.value?.isLoading != true,
                    onClick = {
                        focusManager.clearFocus()
                        if (loginViewModel.validateRegisterForm()) {
                            println("reached here")
                            loginViewModel.userRegister()
                        }

                    },
                    text = "Signup",
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    isLoading = when (uiState) {
                        is UiState.LOADING ->
                            true

                        else ->
                            false

                    }
                )
                VerticalGapMedium()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Already have an account ? ",
                        style = TextStyle(fontSize = smallTextSize, color = Color.Black),
                    )
                    Text(
                        text = "Login",
                        color = YellowDark,
                        modifier = Modifier.clickable {
                            navHostController.navigate(Screens.LoginScreen.route) {
                                popUpTo(
                                    navHostController.graph.startDestinationId
                                ) {
                                    inclusive = true
                                }
                            }
                        },
                        style = TextStyle(fontSize = smallTextSize)

                    )

                }
            }
        }
    }

}