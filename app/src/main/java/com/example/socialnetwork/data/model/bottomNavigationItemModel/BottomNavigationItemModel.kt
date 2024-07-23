package com.example.socialnetwork.data.model.bottomNavigationItemModel

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemModel(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)