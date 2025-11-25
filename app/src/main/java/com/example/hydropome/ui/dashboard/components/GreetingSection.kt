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
import com.example.hydropome.R
import com.example.hydropome.ui.theme.ColorTheme.GreenNormal

@Composable
@Preview(showBackground = true)
fun GreetingSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(GreenNormal)
            .padding(horizontal = 20.dp, vertical = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Halo Mellafesa! 👋🏻",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Berkebun Apa Hari Ini?",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }


        Image(
            painter = painterResource(id = R.drawable.memoji_girls),
            contentDescription = "User Memoji",
            modifier = Modifier
                .height(64.dp)
                .width(100.dp)
        )
    }
}
