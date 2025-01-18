package com.purnendu.myapps.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.purnendu.myapps.models.AppModel
import com.purnendu.myapps.screens.home.components.CustomLazyColumn

@Composable
fun Applications(modifier: Modifier = Modifier, items: List<AppModel>
) {

    val searchText = remember { mutableStateOf("") }
    val filteredAppList = remember { derivedStateOf { items.filter { item -> item.appName.contains(searchText.value, true) } } }

    Column(modifier = modifier.fillMaxSize().padding(horizontal = 10.dp))
    {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Search") },
            trailingIcon = { Icon(Icons.Default.Search, tint = Color.Black, contentDescription = "searchIcon") },
            value = searchText.value,
            onValueChange = { searchText.value = it })

        Spacer(modifier = Modifier.height(5.dp))

        CustomLazyColumn(items = if (searchText.value.isEmpty()) items else filteredAppList.value)

    }




}