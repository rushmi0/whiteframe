package com.example.whiteframe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.whiteframe.ui.component.BottomNavBar
import com.example.whiteframe.ui.component.NavigationGraph
import com.example.whiteframe.ui.theme.WhiteFrameTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhiteFrameTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavBar(navController)
                    }
                ) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        NavigationGraph(navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    WhiteFrameTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavBar(navController)
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationGraph(navController)
            }
        }
    }
}
