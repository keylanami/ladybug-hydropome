package app.motion.android.ui.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.motion.android.R
import app.motion.android.ui.theme.PlusJakarta

@Composable
@Preview
fun ProgressCard(){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    "Belum Ada Progress Tanaman Hari Ini . . .",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, fontFamily = PlusJakarta)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "Ayo pilih tanaman pertama kamu dan mulai sekarang!",
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = PlusJakarta),
                    color = Color.Gray
                )
            }

            Image(
                painter = painterResource(id = R.drawable.daun),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 20.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}