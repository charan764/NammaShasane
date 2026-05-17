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
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StoryScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),

        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Historical Stories",
            color = Color.LightGray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        StoryCard(

            title = "Hampi Stone",

            dynasty = "Vijayanagara Empire",

            story =
                "This inscription records the donation of agricultural land to temple priests during the reign of Krishnadevaraya."
        )

        StoryCard(

            title = "Badami Cave Inscription",

            dynasty = "Chalukya Dynasty",

            story =
                "This stone inscription describes military victories and temple construction by the Chalukya kings."
        )

        StoryCard(

            title = "Halebidu Temple Stone",

            dynasty = "Hoysala Empire",

            story =
                "The inscription praises the artistic excellence and cultural richness of the Hoysala kingdom."
        )
    }
}

@Composable
fun StoryCard(

    title: String,

    dynasty: String,

    story: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {

        Column(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {

            Icon(
                Icons.Default.MenuBook,
                contentDescription = null,
                tint = Color.LightGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = dynasty,
                color = Color.LightGray,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = story,

                color = Color.White,

                fontSize = 17.sp,

                fontFamily = FontFamily.Serif
            )
        }
    }
}