package com.example.nammashasane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.nammashasane.ui.theme.navigation.AppNavigation
import com.example.nammashasane.ui.theme.NammaShasaneTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            NammaShasaneTheme {

                val navController =
                    rememberNavController()

                AppNavigation(navController)
            }
        }
    }
}