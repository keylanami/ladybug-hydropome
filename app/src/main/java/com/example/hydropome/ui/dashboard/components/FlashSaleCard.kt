package com.example.hydropome.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.example.hydropome.ui.dashboard.model.flashsaleItem
import com.example.hydropome.ui.theme.ColorTheme

@Composable
fun FSCard(FlashsaleItem: flashsaleItem ){

    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(20.dp)
            .background(Color.White)
    ){
        Column() {
            Image(
                painter = painterResource(id = FlashsaleItem.imageRes),
                contentDescription = FlashsaleItem.namaItem,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = FlashsaleItem.cateItem,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Thin)
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )


            Text(
                text = FlashsaleItem.namaItem,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = FlashsaleItem.harga,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = ColorTheme.GreenDark
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = FlashsaleItem.disc,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = ColorTheme.BlackDark
                )
            }
        }
    }
}