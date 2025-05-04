package com.example.whiteframe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whiteframe.ui.theme.WhiteFrameTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhiteFrameTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val counter = remember { mutableStateOf(0) }
    var showSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        MyAlignments()

        FloatingActionButton(
            onClick = {
                showSheet = true
                scope.launch { sheetState.show() }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 50.dp, end = 20.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Open Bottom Sheet")
        }

        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showSheet = false
                },
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Counter: ${counter.value}",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = {
                            counter.value -= 1
                        }) {
                            Icon(Icons.Default.Remove, contentDescription = "Decrease")
                        }
                        IconButton(onClick = {
                            counter.value += 1
                        }) {
                            Icon(Icons.Default.Add, contentDescription = "Increase")
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            showSheet = false
                        }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                        Spacer(Modifier.width(8.dp))
                        Text("Close")
                    }
                }
            }
        }
    }
}

@Composable
fun MyAlignments() {
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

        Text(
            text = "Android",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(
                    Color.Blue,
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

        MainScreen()

    }
}