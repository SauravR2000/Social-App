package com.example.socialnetwork.presentation.auth.login

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.CustomButton
import com.example.socialnetwork.components.CustomTextField
import com.example.socialnetwork.components.VerticalGapMedium
import com.example.socialnetwork.components.VerticalGapSmall
import com.example.socialnetwork.constants.backgroundColor
import com.example.socialnetwork.constants.largeTextSize
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.constants.screenPadding
import com.example.socialnetwork.constants.smallTextSize
import com.example.socialnetwork.navigation.Screens
import com.example.socialnetwork.state.UiState
import com.example.socialnetwork.ui.theme.YellowDark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    scope: CoroutineScope?,
    snackbarHostState: SnackbarHostState?,
) {
    val focusManager = LocalFocusManager.current

    //device height and width
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
//    val screenWidth = configuration.screenWidthDp.dp

    //state
    val uiState = loginViewModel.loginData.collectAsState().value
    var snackbarMessage by remember { mutableStateOf("") }
    var showSnackbar by remember { mutableStateOf(false) }

    //UI
    LaunchedEffect(key1 = uiState) {
        if (uiState is UiState.SUCCESS) {
            snackbarMessage = uiState.data
            showSnackbar = true

            navHostController.navigate(Screens.HomeFeedScreen.route) {
                popUpTo(
                    navHostController.graph.startDestinationId
                ) {
                    inclusive = true
                }
            }
        } else if (uiState is UiState.ERROR) {
            snackbarHostState?.currentSnackbarData?.dismiss()
            snackbarMessage = uiState.error.toString()
            showSnackbar = true
        }
    }


    //UI
    if (showSnackbar) {
        if (scope != null && snackbarHostState != null) {

            LaunchedEffect(showSnackbar) {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = snackbarMessage,
                        actionLabel = "Dismiss",
                        duration = SnackbarDuration.Long
                    )
                    showSnackbar = false

                }
            }
        }
    }



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
                    text = "Login",
                    style = TextStyle(fontSize = largeTextSize, fontWeight = FontWeight.Bold)
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
                Text(
                    text = "Forgot Password?",
                    color = MaterialTheme.colorScheme.primary,
                    style = TextStyle(fontSize = smallTextSize, color = Color.Black)
                )
                VerticalGapSmall()//


                CustomButton(
//                    isEnabled = state.value?.isLoading != true,
                    onClick = {
                        focusManager.clearFocus()
                        if (loginViewModel.validateLoginForm()) {
                            println("reached here")
                            loginViewModel.userLogin()
                        }
                    },
                    text = "Login",
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
                        text = "Don't have an account ? ",
                        style = TextStyle(fontSize = smallTextSize, color = Color.Black),
//                        color = Color.Red
                    )
                    Text(
                        text = "Register",
                        color = YellowDark,
                        modifier = Modifier.clickable {
                            navHostController.navigate(Screens.RegisterScreen.route)
                        },
                        style = TextStyle(fontSize = smallTextSize)

                    )

                }
            }
        }
    }


}


