package com.example.socialnetwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.socialnetwork.navigation.Navigation
import com.example.socialnetwork.ui.theme.SocialNetworkTheme
import com.example.socialnetwork.utils.PreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialNetworkTheme(darkTheme = false) {
                Navigation()
            }
        }
    }
}

