package com.example.hydropome.ui.dashboard.model

import androidx.compose.ui.graphics.Color


data class PlantItem(
    val name: String,
    val difficulty: String,
    val duration: String,
    val imageRes: Int,
    val difficultyColor: Color
)
