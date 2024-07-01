package com.example.socialnetwork.components
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.socialnetwork.constants.mediumTextSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    navController: NavHostController,
//    actions: @Composable () -> Unit,
    actions: List<@Composable () -> Unit> = emptyList(),
) {



    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            println("the previous back stack = ${navController.previousBackStackEntry}")

            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Go Back",
                        tint = Color.White
                    )
                }
            } else {
                null
            }
        },
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                color = Color.White,
                style = TextStyle(fontSize = mediumTextSize, fontWeight = FontWeight.Bold)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        actions = {
            Row {
                actions.forEachIndexed { index, action ->
                    action()
                    if (index < actions.size - 1) {
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                    }
                }
            }
        },
    )
}