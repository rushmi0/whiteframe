package com.example.whiteframe.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whiteframe.ui.screen.MainScreen
import com.example.whiteframe.ui.screen.ProfileScreen
import com.example.whiteframe.ui.Screen
import com.example.whiteframe.ui.screen.AnimationsScreen
import com.example.whiteframe.ui.screen.DemoScreen
import com.example.whiteframe.ui.screen.WalletScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) { MainScreen() }
        composable(route = Screen.Profile.route) { ProfileScreen() }
        composable(route = Screen.Animations.route) { AnimationsScreen() }
        composable(route = Screen.Wallet.route) { WalletScreen() }
        composable(route = Screen.Demo.route) { DemoScreen() }
    }
}

