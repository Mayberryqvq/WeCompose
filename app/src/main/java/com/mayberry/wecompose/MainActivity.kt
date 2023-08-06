package com.mayberry.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.mayberry.wecompose.ui.theme.WeBottomBar
import com.mayberry.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    var selectedTab by mutableStateOf(0);
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
                    val viewModel: WeViewModel = viewModel()
                    HorizontalPager(count = 4) { page ->
                        when(page) {
                            0 -> Box(Modifier.fillMaxSize())
                            1 -> Box(Modifier.fillMaxSize())
                            2 -> Box(Modifier.fillMaxSize())
                            3 -> Box(Modifier.fillMaxSize())
                        }
                    }
                    WeBottomBar(viewModel.selectedTab) {
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }


}
