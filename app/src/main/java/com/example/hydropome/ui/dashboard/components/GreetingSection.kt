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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hydropome.R
import com.example.hydropome.ui.theme.ColorTheme.GreenNormal
import com.example.hydropome.ui.theme.Manrope
import com.example.hydropome.ui.theme.PlusJakarta

@Composable
@Preview(showBackground = true)
fun GreetingSection() {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .background(GreenNormal)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                Text(
                    text = "Halo Mellafesa! 👋🏻",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = PlusJakarta,
                        fontSize = 13.sp
                    ),
                    color = Color.White.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Berkebun Apa Hari Ini?",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = Manrope,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    ),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                painter = painterResource(id = R.drawable.memoji_girls),
                contentDescription = "User Memoji",
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            )
        }
    }
}