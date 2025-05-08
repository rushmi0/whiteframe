package com.example.whiteframe.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayCount(counter: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 380.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFE0F7FA),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 12.dp, vertical = 5 .dp)
        ) {
            Text(
                text = "Count: $counter",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
