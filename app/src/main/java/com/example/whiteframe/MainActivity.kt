package com.example.whiteframe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.whiteframe.ui.theme.WhiteFrameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhiteFrameTheme {
                MyAlignments()
            }
        }
    }

}

@Composable
private fun MyAlignments() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(top = 35.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Hello",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red, shape = RoundedCornerShape(7.dp))
                .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
        )
        //Spacer(modifier = Modifier.size(20.dp))

        Text(
            text = "Kotlin",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(
                    Color.Green,
                    shape = RoundedCornerShape(
                        topStart = 7.dp,
                        topEnd = 7.dp,
                    )
                )
                .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
        )
        //Spacer(modifier = Modifier.size(20.dp))

        Text(
            text = "Android",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue,
                    shape = RoundedCornerShape(
                        bottomStart = 7.dp,
                        bottomEnd = 7.dp
                    )
                )
                .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhiteFrameTheme {

        MyAlignments()

    }
}