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
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.VolumeUp
import android.speech.tts.TextToSpeech
import java.util.Locale
import androidx.compose.runtime.DisposableEffect
import com.example.nammashasane.data.model.InscriptionEntity

@Composable
fun HomeScreen(
    navController: NavController
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val inscriptions = listOf(
        InscriptionEntity(
            title = "Hampi Stone",
            location = "Hampi",
            translation = "This inscription records a land gift.",
            dynasty = "Vijayanagara",
            latitude = 15.3350,
            longitude = 76.4600,
            history = "Recorded during the reign of Deva Raya II, this inscription highlights the agrarian economy of the empire.",
            imageUrl = "https://th.bing.com/th/id/OIP.iP-iE_N2p_hSj7VnJ3-r8AHaE8?rs=1&pid=ImgDetMain"
        ),
        InscriptionEntity(
            title = "Badami Inscription",
            location = "Badami",
            translation = "Victory of the Chalukyas.",
            dynasty = "Chalukya",
            latitude = 15.9149,
            longitude = 75.6768,
            history = "Engraved on the canyon walls, it commemorates Pulakeshin I's fortification of Vatapi.",
            imageUrl = "https://th.bing.com/th/id/OIP.PzK_X4M_0mE7fF_L_pX-qAHaE8?rs=1&pid=ImgDetMain"
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

    val filteredList = inscriptions.filter {

        it.title.contains(
            searchText,
            ignoreCase = true
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Namma-Shasane",
                color = Color.LightGray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.height(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search Inscription")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("map")
            }
        ) {

            Icon(Icons.Default.Map, null)

            Spacer(modifier = Modifier.height(5.dp))

            Text("View Heritage Map")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate("camera")
            }
        ) {

            Icon(Icons.Default.PhotoCamera, null)

            Spacer(modifier = Modifier.height(5.dp))

            Text("Scan Inscription")
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(filteredList) { item ->

                InscriptionCard(item, tts)
            }
        }
    }
}

@Composable
fun InscriptionCard(
    inscription: InscriptionEntity,
    tts: TextToSpeech?
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = inscription.imageUrl,
                contentDescription = inscription.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = inscription.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = {
                        tts?.speak("${inscription.title}. ${inscription.history}", TextToSpeech.QUEUE_FLUSH, null, null)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                ) {
                    Icon(Icons.Default.VolumeUp, contentDescription = "Listen")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Location: ${inscription.location}",
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "History: ${inscription.history}",
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Translation: ${inscription.translation}",
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }
    }
}
