package com.example.hydropome.ui.dashboard.components

import com.example.hydropome.R
import com.example.hydropome.ui.dashboard.model.PlantItem
import com.example.hydropome.ui.theme.ColorTheme

val plantDummy = listOf(
    PlantItem(
        name = "Selada Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.selada_hidroponik,
        difficultyColor = ColorTheme.GreenLight
    ),
    PlantItem(
        name = "Bayam Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.bayam_hidroponik,
        difficultyColor = ColorTheme.GreenLight
    ),
    PlantItem(
        name = "Pakcoy Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.pakcoy_hidroponik,
        difficultyColor = ColorTheme.GreenLight
    ),
    PlantItem(
        name = "Tomat Cherry",
        difficulty = "Sedang",
        duration = "5-6 Ming",
        imageRes = R.drawable.tomat_cherry,
        difficultyColor = ColorTheme.OrangeDark
    ),
    PlantItem(
        name = "Seledri Hidroponik",
        difficulty = "Sedang",
        duration = "5-6 Ming",
        imageRes = R.drawable.seledri_hidroponik,
        difficultyColor = ColorTheme.OrangeDark
    ),
    PlantItem(
        name = "Stroberi Hidroponik",
        difficulty = "Sulit",
        duration = "12-16 Ming",
        imageRes = R.drawable.stroberi_hidroponik,
        difficultyColor = ColorTheme.OrangeDarker
    )
)