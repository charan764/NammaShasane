package com.example.nammashasane.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CameraScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Inscription Scanner",
            color = Color.LightGray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),

                horizontalAlignment =
                    Alignment.CenterHorizontally,

                verticalArrangement =
                    Arrangement.Center
            ) {

                Icon(
                    Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Camera Preview",
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

            }
        ) {

            Icon(
                Icons.Default.CameraAlt,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text("Capture Inscription")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

            }
        ) {

            Icon(
                Icons.Default.Image,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text("Upload From Gallery")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                "Upload ancient inscription images for AI translation and historical analysis.",

            color = Color.Gray,

            fontSize = 16.sp
        )
    }
}