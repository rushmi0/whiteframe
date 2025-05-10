package com.example.whiteframe.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whiteframe.ui.component.MenuTop

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text =  "This is Main Screen")
    }
}

