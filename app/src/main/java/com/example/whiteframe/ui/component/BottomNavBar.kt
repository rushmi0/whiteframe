package com.example.whiteframe.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.whiteframe.ui.Screen

data class NavItem(val screen: Screen, val icon: ImageVector)

@Composable
fun BottomNavBar(navController: NavController) {
    val navItems = listOf(
        NavItem(Screen.Home, Icons.Default.Home),
        NavItem(Screen.Demo, Icons.Default.Layers),
        NavItem(Screen.Profile, Icons.Default.Person),
        NavItem(Screen.Wallet, Icons.Default.Wallet),
        NavItem(Screen.Animations, Icons.Default.Animation),
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    if (currentRoute != item.screen.route) {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.screen.title) },
                label = { Text(item.screen.title) }
            )
        }
    }
}
