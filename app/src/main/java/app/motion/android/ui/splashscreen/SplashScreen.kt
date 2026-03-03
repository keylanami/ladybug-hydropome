package app.motion.android.ui.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.motion.android.R

@Preview
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Gambar logo
            Image(
                painter = painterResource(id = R.drawable.img_hydropome_logo),
                contentDescription = "HydropoMe Logo",
                modifier = Modifier
                    .size(160.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "HydropoMe",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3B7A6E)
            )

            // Slogan
            Text(
                text = "Hijaukan Bumi Dengan Inovasi",
                fontSize = 14.sp,
                color = Color(0xFF3B7A6E),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
