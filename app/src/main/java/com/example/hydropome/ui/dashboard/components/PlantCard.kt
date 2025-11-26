package com.example.hydropome.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults // 1. Pastikan import ini ada
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hydropome.R
import com.example.hydropome.ui.dashboard.model.PlantItem
import com.example.hydropome.ui.theme.ColorTheme
import com.example.hydropome.ui.theme.PlusJakarta

@Composable
fun PlantCard(plantItem: PlantItem){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(240.dp)
            .height(220.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = plantItem.imageRes),
                contentDescription = plantItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp))

            Text(
                text = plantItem.name,
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = PlusJakarta, fontWeight = FontWeight.Bold),
                color = ColorTheme.BlackNormal
            )

            Spacer(
                modifier = Modifier
                    .height(4.dp))


            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(plantItem.difficultyColor)
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = plantItem.difficulty,
                    style = MaterialTheme.typography.bodySmall.copy(fontFamily = PlusJakarta, fontWeight = FontWeight.SemiBold),
                    color = plantItem.difficultyColor
                )

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.jam),
                    contentDescription = "duration",
                    modifier = Modifier.height(14.dp).width(14.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = plantItem.duration,
                    style = MaterialTheme.typography.bodySmall.copy(fontFamily = PlusJakarta, fontWeight = FontWeight.SemiBold),
                    color = ColorTheme.GreyNormal

                )
            }
        }
    }
}