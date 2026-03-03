package app.motion.android.ui.dashboard.components

import app.motion.android.R
import app.motion.android.ui.dashboard.model.PlantItem
import app.motion.android.ui.theme.GreenLight
import app.motion.android.ui.theme.OrangeDark
import app.motion.android.ui.theme.OrangeDarker

val plantDummy = listOf(
    PlantItem(
        name = "Selada Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.selada_hidroponik,
        difficultyColor = GreenLight
    ),
    PlantItem(
        name = "Bayam Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.bayam_hidroponik,
        difficultyColor = GreenLight
    ),
    PlantItem(
        name = "Pakcoy Hidroponik",
        difficulty = "Mudah",
        duration = "3-5 Ming",
        imageRes = R.drawable.pakcoy_hidroponik,
        difficultyColor = GreenLight
    ),
    PlantItem(
        name = "Tomat Cherry",
        difficulty = "Sedang",
        duration = "5-6 Ming",
        imageRes = R.drawable.tomat_cherry,
        difficultyColor = OrangeDark
    ),
    PlantItem(
        name = "Seledri Hidroponik",
        difficulty = "Sedang",
        duration = "5-6 Ming",
        imageRes = R.drawable.seledri_hidroponik,
        difficultyColor = OrangeDark
    ),
    PlantItem(
        name = "Stroberi Hidroponik",
        difficulty = "Sulit",
        duration = "12-16 Ming",
        imageRes = R.drawable.stroberi_hidroponik,
        difficultyColor = OrangeDarker
    )
)