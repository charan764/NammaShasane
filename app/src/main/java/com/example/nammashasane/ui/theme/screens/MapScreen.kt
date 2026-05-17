package com.example.nammashasane.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import android.speech.tts.TextToSpeech
import java.util.Locale
import androidx.compose.runtime.remember
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HeritageLocation(
    val place: String,
    val dynasty: String,
    val district: String,
    val latitude: Double,
    val longitude: Double,
    val history: String,
    val imageUrl: String
)

@Composable
fun MapScreen() {

    val heritageLocations = listOf(
        HeritageLocation(
            place = "Hampi",
            dynasty = "Vijayanagara Empire",
            district = "Vijayanagara",
            latitude = 15.3350,
            longitude = 76.4600,
            history = "Hampi was the capital of the Vijayanagara Empire in the 14th century. It is a UNESCO World Heritage site known for its stunning temples and ruins.",
            imageUrl = "https://th.bing.com/th/id/OIP.iP-iE_N2p_hSj7VnJ3-r8AHaE8?rs=1&pid=ImgDetMain"
        ),
        HeritageLocation(
            place = "Badami",
            dynasty = "Chalukya Dynasty",
            district = "Bagalkot",
            latitude = 15.9149,
            longitude = 75.6768,
            history = "Badami, formerly known as Vatapi, was the regal capital of the early Chalukyas. It is famous for its rock-cut cave temples.",
            imageUrl = "https://th.bing.com/th/id/OIP.PzK_X4M_0mE7fF_L_pX-qAHaE8?rs=1&pid=ImgDetMain"
        ),
        HeritageLocation(
            place = "Halebidu",
            dynasty = "Hoysala Empire",
            district = "Hassan",
            latitude = 13.2131,
            longitude = 75.9944,
            history = "Halebidu was the regal capital of the Hoysala Empire in the 12th century. It is home to some of the best examples of Hoysala architecture.",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hoysaleswara_Temple_at_Halebidu.jpg/1200px-Hoysaleswara_Temple_at_Halebidu.jpg"
        )
    )

    val context = LocalContext.current
    val tts = remember {
        var textToSpeech: TextToSpeech? = null
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
            }
        }
        textToSpeech
    }

    DisposableEffect(Unit) {
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Text(
            text = "Heritage Map",
            color = Color.LightGray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Historical Places of Karnataka",
            color = Color.Gray,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(heritageLocations) { location ->

                HeritageCard(location, tts)
            }
        }
    }
}

@Composable
fun HeritageCard(
    location: HeritageLocation,
    tts: TextToSpeech?
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                val gmmIntentUri = Uri.parse("geo:${location.latitude},${location.longitude}?q=${Uri.encode(location.place)}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }
    ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = location.imageUrl,
                contentDescription = location.place,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = location.place,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Dynasty: ${location.dynasty}",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                }

                Row {
                    Button(
                        onClick = {
                            tts?.speak(location.history, TextToSpeech.QUEUE_FLUSH, null, null)
                        },
                        modifier = Modifier.padding(end = 4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                    ) {
                        Icon(Icons.Default.VolumeUp, contentDescription = "Listen")
                    }

                    Button(
                        onClick = {
                            val gmmIntentUri = Uri.parse("google.navigation:q=${location.latitude},${location.longitude}")
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps")
                            context.startActivity(mapIntent)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                    ) {
                        Icon(Icons.Default.Directions, contentDescription = null)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = location.history,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "District: ${location.district}",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
