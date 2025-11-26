package com.example.hydropome.ui.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydropome.ui.theme.PlusJakarta

@Composable
@Preview

fun RecommendationSection(){
    Column (
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Rekomendasi Untukmu",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontFamily = PlusJakarta)
            )

            Text(
                text = "Lihat Semua",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF0D6B4B)
            )
        }

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.height(480.dp)
        ) {
            items(plantDummy) { plant ->
                PlantCard(plant)
            }
        }

    }
}