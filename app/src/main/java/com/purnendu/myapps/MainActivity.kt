package com.purnendu.myapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.purnendu.myapps.screens.drawings.MusicKnob
import com.purnendu.myapps.ui.theme.MyAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppsTheme {
                //HomeScreen()

                Box(modifier = Modifier.fillMaxSize().background(color = Color.Cyan), contentAlignment=Alignment.Center)
                {
                    //YouTube()
                    //Trello()
                    //Instagram()
                    //DroidIcon()
                    //SpotifyIcon()
                    MusicKnob(modifier = Modifier.size(300.dp)) {  }
                }

            }
        }
    }
}



