package com.purnendu.myapps.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.purnendu.myapps.R

@Composable
fun SingleAppItem(
    imageUrl: String,
    appName: String,
    status:String,
    modifier: Modifier = Modifier
) {

    val appStatus=remember{ mutableStateOf(status=="Active") }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {

        Row( verticalAlignment = Alignment.CenterVertically) {

            AsyncImage(
                modifier = Modifier.size(50.dp),
                model =imageUrl,
                placeholder = painterResource(id = R.drawable.loader),
                contentScale = ContentScale.Crop,
                contentDescription = "AppIcon")

            Spacer(modifier = Modifier.width(5.dp))

            Text(text = appName, color = Color.Gray)

        }

        Switch(checked = appStatus.value, onCheckedChange = {appStatus.value=!appStatus.value}, colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFF48bd77),
            checkedTrackColor =Color(0xFF9dd9b6),
            uncheckedThumbColor = Color(0xFF9dd9b6),
            uncheckedTrackColor = Color.Red

        ))

    }

}