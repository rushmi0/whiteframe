package com.example.whiteframe.ui


sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Profile : Screen("profile", "Profile")
    object Animations : Screen("animations", "Anims")
    object Wallet: Screen("wallet", "Wallet")
    object Demo: Screen("demo", "Demo")
}
