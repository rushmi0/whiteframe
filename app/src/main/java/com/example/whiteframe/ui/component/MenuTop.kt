package com.example.whiteframe.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whiteframe.R


@Composable
fun MenuTop() {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(

            //Color(R.color.purple_200.toString()),
            Color(0xFFBFADEE),
            Color(0xFFD1C4E9),
        ),
        startY = 0.0f,
        endY = 1000.0f
    )

    // สร้างสถานะเพื่อเก็บ index ของ tab ที่เลือก
    val selectedTabIndex = remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = gradientBrush)
            .systemBarsPadding() // ใช้ padding เผื่อ StatusBar โดยไม่ต้องตั้งค่าจาก SystemUiController
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Wallet",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            // ปรับให้ใช้ selectedTabIndex ในการเลือก tab ที่กด
            TabButton(text = "Assets", selected = selectedTabIndex.value == 0) {
                selectedTabIndex.value = 0
            }
            Spacer(modifier = Modifier.width(12.dp))
            TabButton(text = "NFTs", selected = selectedTabIndex.value == 1) {
                selectedTabIndex.value = 1
            }
            Spacer(modifier = Modifier.width(12.dp))
            TabButton(text = "Market", selected = selectedTabIndex.value == 2) {
                selectedTabIndex.value = 2
            }
        }
    }
}

@Composable
fun TabButton(text: String, selected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (selected) Color.White.copy(alpha = 0.3f) else Color.Transparent
    val textColor = if (selected) Color.White else Color(0xFFEDE7F6)

    Box(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}



@Preview(name = "MenuTop")
@Composable
private fun PreviewMenuTop() {
    MenuTop()
}