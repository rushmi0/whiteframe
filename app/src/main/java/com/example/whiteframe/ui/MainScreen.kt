package com.example.whiteframe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainScreen() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    // ย้าย counter ไปเป็น state กลาง
    val counter = remember { mutableStateOf(0) }

    var showSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(top = 35.dp),
    ) {
        AlignmentRow()

        DisplayCount(counter = counter.value)

        ButtonTrigger(
            onPlus = { counter.value += 1 },
            onMinus = { counter.value -= 1 }
        )

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
                BottomSheetContent(
                    counter = counter.value,
                    onPlus = { counter.value += 1 },
                    onMinus = { counter.value -= 1 },
                    onClose = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            showSheet = false
                        }
                    }
                )
            }
        }
    }
}

