package com.example.socialnetwork
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowSnackbar(snackbarMessage: String?, onHide: () -> Unit) {
    if (snackbarMessage != null) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                Button(onClick = onHide) {
                    Text("Dismiss")
                }
            },
        ) {
            Text(snackbarMessage)
        }
    }
}
