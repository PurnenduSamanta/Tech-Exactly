package com.purnendu.myapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.purnendu.myapps.screens.home.HomeScreen
import com.purnendu.myapps.ui.theme.MyAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppsTheme {
                HomeScreen()
            }
        }
    }
}



