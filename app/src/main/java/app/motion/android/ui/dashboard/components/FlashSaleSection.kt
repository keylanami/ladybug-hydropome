package app.motion.android.ui.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.motion.android.ui.theme.PlusJakarta

@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
fun FlashSale(){

    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = "Starter Kit Flash Sale 🔥",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontFamily = PlusJakarta)
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            items(saleDummy) { sales ->
                FSCard(sales)
            }
        }
    }
}
