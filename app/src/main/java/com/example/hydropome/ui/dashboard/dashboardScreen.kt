package com.example.hydropome.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydropome.ui.dashboard.components.FlashSale
import com.example.hydropome.ui.dashboard.components.GreetingSection
import com.example.hydropome.ui.dashboard.components.ProgressCard
import com.example.hydropome.ui.dashboard.components.RecommendationSection
import com.example.hydropome.ui.dashboard.components.SearchBar

@Composable
@Preview

fun dashboardScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .verticalScroll(rememberScrollState())
    ) {
        GreetingSection()
        Spacer(modifier = Modifier.height(16.dp))

        ProgressCard()
        Spacer(modifier = Modifier.height(20.dp))

        SearchBar()
        Spacer(modifier = Modifier.height(20.dp))

        RecommendationSection()
        Spacer(modifier = Modifier.height(24.dp))

        FlashSale()
        Spacer(modifier = Modifier.height(50.dp))
    }
}