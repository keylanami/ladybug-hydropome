package app.motion.android.ui.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.motion.android.R
import app.motion.android.common.model.OnboardingPage

@Composable
fun OnboardingScreen() {
    var currentPage by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    val pages = listOf(
        OnboardingPage(
            title = "Tanam Sayur Segar dari Rumah Tanpa Ribet! \uD83E\uDD55\uD83C\uDF45",
            description = "Bersama HydropoMe, menanam sayuran untuk hidup lebih sehat dan hemat jadi lebih mudah!",
            imageRes = R.drawable.img_onboarding1
        ),
        OnboardingPage(
            title = "Belanja Starter Kit & Jual Hasil Panen!",
            description = "Belanja, jual panen, dan penuhi kebutuhanmu di marketplace kami. Praktis banget buat kamu yang suka berkebun dari rumah!",
            imageRes = R.drawable.img_onboarding2
        )
    )

    val totalPages = pages.size

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D5F5D))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top section dengan gambar dan curved bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.2f)
            ) {
                // Background image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color.LightGray)
                ) {
                    // Gambar sesuai halaman saat ini
                    Image(
                        painter = painterResource(id = pages[currentPage].imageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                // Curved bottom overlay
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val path = Path().apply {
                            moveTo(0f, 0f)
                            quadraticBezierTo(
                                size.width / 2f,
                                size.height * 2,
                                size.width,
                                0f
                            )
                            lineTo(size.width, size.height)
                            lineTo(0f, size.height)
                            close()
                        }
                        drawPath(
                            path = path,
                            color = Color(0xFF2D5F5D)
                        )
                    }
                }

                // Button "Lewati" di pojok kanan atas
                TextButton(
                    onClick = { /* Handle skip */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(20.dp))
                ) {
                    Text(
                        "Lewati",
                        color = Color(0xFF2D5F5D),
                        fontSize = 14.sp
                    )
                }
            }

            // Bottom section dengan text dan navigation
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Content area dengan scroll
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(scrollState)
                        .padding(horizontal = 24.dp)
                        .padding(top = 16.dp, bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Title - dinamis sesuai halaman
                    Text(
                        text = pages[currentPage].title,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description - dinamis sesuai halaman
                    Text(
                        text = pages[currentPage].description,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                // Navigation controls - fixed di bawah
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Back button - hide jika di halaman pertama
                    if (currentPage > 0) {
                        IconButton(
                            onClick = { currentPage-- },
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    Color.White.copy(alpha = 0.2f),
                                    RoundedCornerShape(12.dp)
                                )
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    } else {
                        // Spacer untuk menjaga layout tetap seimbang
                        Spacer(modifier = Modifier.size(48.dp))
                    }

                    // Page indicators
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(totalPages) { index ->
                            Box(
                                modifier = Modifier
                                    .size(if (index == currentPage) 12.dp else 8.dp)
                                    .background(
                                        if (index == currentPage)
                                            Color.White
                                        else
                                            Color.White.copy(alpha = 0.4f),
                                        CircleShape
                                    )
                            )
                        }
                    }

                    // Forward button - hide jika di halaman terakhir
                    IconButton(
                        onClick = { if (currentPage < totalPages - 1) currentPage++ },
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                Color.White.copy(alpha = 0.2f),
                                RoundedCornerShape(12.dp)
                            )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Next",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}
