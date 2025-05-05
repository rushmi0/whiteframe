package com.example.whiteframe.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun AlignmentRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOf(
            Triple("Hello", Color.Red, RoundedCornerShape(7.dp)),
            Triple("Kotlin", Color.Green, RoundedCornerShape(topStart = 7.dp, topEnd = 7.dp)),
            Triple("Android", Color.Blue, RoundedCornerShape(bottomStart = 7.dp, bottomEnd = 7.dp)),
        ).forEach { (text, bgColor, shape) ->
            Text(
                text = text,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(bgColor, shape)
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
            )
        }
    }
}
