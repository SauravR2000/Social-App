package com.example.socialnetwork.presentation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.data.model.bottomNavigationItemModel.BottomNavigationItemModel
import com.example.socialnetwork.navigation.MainScreenNavigation
import com.example.socialnetwork.navigation.Screens
import kotlinx.coroutines.CoroutineScope


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    mainController: NavHostController = rememberNavController(),
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
) {
    val items = listOf(
        BottomNavigationItemModel(
            title = Screens.HomeFeedScreen.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItemModel(
            title = Screens.ProfileScreen.route,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false,
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {

            val screens = listOf(
                Screens.HomeFeedScreen,
                Screens.ProfileScreen,
            )


            val navBackStackEntry by mainController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination


            var bottomBarDestination = false;

            bottomBarDestination = screens.any {

                it.route == currentDestination?.route
            }


            if (bottomBarDestination) {
                NavigationBar(
//                    containerColor = Color.Black,
                    modifier = Modifier.shadow(20.dp)
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = false,
                            onClick = {
                                selectedItemIndex = index
                                mainController.navigate(item.title) {
                                    popUpTo(mainController.graph.findStartDestination().id)
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount != null) {
                                        Badge() {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else {
                                            item.unselectedIcon
                                        },
                                        contentDescription = item.title,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        MainScreenNavigation(
            mainNavController = mainController,
            scope = scope,
            snackBarHostState = snackBarHostState,
            navController = navController,
        )
    }
}