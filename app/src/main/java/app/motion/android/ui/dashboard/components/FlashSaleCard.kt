package app.motion.android.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import app.motion.android.ui.dashboard.model.flashsaleItem
import app.motion.android.ui.theme.GreenDark
import app.motion.android.ui.theme.PlusJakarta

@Composable
fun FSCard(item: flashsaleItem) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(190.dp)
            .height(264.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.namaItem,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(top = 10.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = item.cateItem,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Thin,
                    fontFamily = PlusJakarta
                ),
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.namaItem,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = PlusJakarta
                ),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.harga,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = PlusJakarta
                    ),
                    color = GreenDark
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = item.disc,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Normal,
                        textDecoration = TextDecoration.LineThrough,
                        fontFamily = PlusJakarta
                    ),
                    color = Color.Gray
                )
            }
        }
    }
}
