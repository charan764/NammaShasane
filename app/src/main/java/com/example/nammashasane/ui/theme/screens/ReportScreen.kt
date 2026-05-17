package com.example.nammashasane.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReportScreen() {

    var reportText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Text(
            text = "Heritage Report",
            color = Color.LightGray,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = reportText,
            onValueChange = {
                reportText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Describe damage")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            }
        ) {

            Text("Submit Report")
        }
    }
}