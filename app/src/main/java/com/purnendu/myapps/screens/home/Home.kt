package com.purnendu.myapps.screens.home

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.myapps.R
import com.purnendu.myapps.models.AppModel
import com.purnendu.myapps.utils.Constants.FIRST_TAB_NAME
import com.purnendu.myapps.utils.Constants.SECOND_TAB_NAME
import com.purnendu.myapps.utils.Response
import com.purnendu.myapps.utils.isNetworkAvailable
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,viewModel: HomeViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {


    val pageState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        2
    }

    val tabs = listOf(FIRST_TAB_NAME, SECOND_TAB_NAME)

    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    val isProgressIndicatorVisible = remember { mutableStateOf(false) }

    val appsList = remember { mutableStateListOf<AppModel>() }


    LaunchedEffect(key1 = viewModel.response.value)
    {
        when (val data = viewModel.response.value) {
            is Response.Loading -> {
                isProgressIndicatorVisible.value = true
            }

            is Response.Success -> {
                isProgressIndicatorVisible.value = false
                appsList.clear()
                viewModel.response.value.data?.forEach {
                    appsList.add(AppModel(
                        appIcon=it.app_icon,
                        appId= it.app_id,
                        appName=it.app_name,
                        appPackageName=it.app_package_name
                    ))
                }
            }

            is Response.Error -> {
                isProgressIndicatorVisible.value = false
                Toast.makeText(context, data.message.toString(), Toast.LENGTH_SHORT).show()
            }

            is Response.Empty -> {  isProgressIndicatorVisible.value = false}
        }

    }


    LaunchedEffect(key1 = Unit)
    {

        if(!isNetworkAvailable(context))
        {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
            return@LaunchedEffect
        }

        //Getting Apps list
        viewModel.getApps()

    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .fillMaxWidth()
                    .background(color = Color.Green.copy(alpha = 0.4f))
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription ="avatar"
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "My Apps", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }

        },
    ) { innerPadding ->

        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize())
        {

            if(isProgressIndicatorVisible.value)
            {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
                {
                    CircularProgressIndicator()
                }

                return@Scaffold
            }


            TabRow(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color.Green.copy(alpha = 0.4f),
                selectedTabIndex = pageState.currentPage,
                indicator = { positionList ->
                    SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(positionList[pageState.currentPage]),
                        height = 2.dp,
                        color = Color(0xFFd22c16)
                    )
                }
            ) {
                tabs.forEachIndexed { index, value ->
                    Tab(selected = pageState.currentPage == index, onClick = {
                        coroutineScope.launch { pageState.animateScrollToPage(index) }
                    }, text = {
                        Text(text = value, color = Color.White)
                    }
                    )
                }
            }

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp))
            {

                HorizontalPager(modifier = Modifier.fillMaxSize(), state = pageState, userScrollEnabled = true)
                { pageContentIndex ->
                    when (pageContentIndex) {
                        0 -> {
                            ListingApps(modifier = Modifier.fillMaxWidth(), items =appsList.toList() )
                        }

                        1 -> {
                            SearchingApps(modifier = Modifier.fillMaxWidth(),items =appsList.toList())
                        }
                    }
                }


            }


        }


    }


}