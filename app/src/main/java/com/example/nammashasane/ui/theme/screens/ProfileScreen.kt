package com.example.nammashasane.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import android.util.Log
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.width

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    var isLoggedIn by remember { mutableStateOf(false) }
    var userName by remember { mutableStateOf("Heritage Explorer") }
    var userEmail by remember { mutableStateOf("guest@nammashasane.com") }
    var userPhotoUrl by remember { mutableStateOf("") }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()

    val googleSignInClient = GoogleSignIn.getClient(context, gso)

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            if (account != null) {
                isLoggedIn = true
                userName = account.displayName ?: "Heritage Explorer"
                userEmail = account.email ?: ""
                userPhotoUrl = account.photoUrl?.toString() ?: ""
            }
        } catch (e: ApiException) {
            Log.e("GoogleSignIn", "Sign in failed: ${e.statusCode}")
        }
    }

    // Check if already signed in on start
    LaunchedEffect(Unit) {
        val lastAccount = GoogleSignIn.getLastSignedInAccount(context)
        if (lastAccount != null) {
            isLoggedIn = true
            userName = lastAccount.displayName ?: "Heritage Explorer"
            userEmail = lastAccount.email ?: ""
            userPhotoUrl = lastAccount.photoUrl?.toString() ?: ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        if (userPhotoUrl.isNotEmpty()) {
            AsyncImage(
                model = userPhotoUrl,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .height(120.dp)
                    .clip(CircleShape)
            )
        } else {
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier
                    .height(120.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = userName,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = userEmail,
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (!isLoggedIn) {
            Button(
                onClick = {
                    val signInIntent = googleSignInClient.signInIntent
                    launcher.launch(signInIntent)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Text("Sign In with Google")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Icon(Icons.Default.Email, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Login with Email")
            }
        } else {
            Button(
                onClick = {
                    googleSignInClient.signOut().addOnCompleteListener {
                        isLoggedIn = false
                        userName = "Heritage Explorer"
                        userEmail = "guest@nammashasane.com"
                        userPhotoUrl = ""
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)
            ) {
                Text("Sign Out")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(16.dp)
            ) {

                Text(
                    text = "User Statistics",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Scanned Stones: 12",
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Saved Stories: 8",
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Visited Heritage Sites: 5",
                    color = Color.LightGray
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                Icons.Default.History,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text("View History")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                Icons.Default.Report,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text("Report Damaged Heritage")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =
                "Together we preserve ancient inscriptions and Karnataka history.",

            color = Color.Gray,

            fontSize = 15.sp
        )
    }
}
