package com.purnendu.myapps.screens.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.purnendu.myapps.models.AppModel

@Composable
fun CustomLazyColumn(modifier: Modifier = Modifier,items: List<AppModel>) {

    LazyColumn(modifier = modifier)
    {
        itemsIndexed(items = items){ index,item->

            SingleAppItem(imageUrl = item.app_icon, appName = item.app_name, appPackageName = item.app_package_name)

            if(index!=items.lastIndex)
                Spacer(modifier = Modifier.height(5.dp))

        }
    }

}