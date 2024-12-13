package com.purnendu.myapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.purnendu.myapps.screens.drawings.Instagram
import com.purnendu.myapps.screens.drawings.Trello
import com.purnendu.myapps.screens.drawings.YouTube
import com.purnendu.myapps.screens.home.HomeScreen
import com.purnendu.myapps.ui.theme.MyAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppsTheme {
                HomeScreen()

               /* Box(modifier = Modifier.fillMaxSize().background(color = Color.Cyan), contentAlignment=Alignment.Center)
                {
                    //YouTube()
                   //Trello()
                    //Instagram()
                }*/
            }
        }
    }
}



