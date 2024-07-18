package com.purnendu.myapps.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.purnendu.myapps.models.AppModel
import com.purnendu.myapps.networking.responseModel.AppListResponse
import com.purnendu.myapps.screens.home.components.CustomLazyColumn
import com.purnendu.myapps.screens.home.components.SingleAppItem

@Composable
fun ListingApps(modifier: Modifier = Modifier,items: List<AppModel>
) {

    CustomLazyColumn(modifier = modifier, items=items)


}