package com.purnendu.myapps.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SingleAppItem(
    imageUrl: String,
    appName: String,
    appPackageName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {


        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                ,
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = "AppIcon"
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column {

            Text(text = appName)

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = appPackageName)

        }

    }

}