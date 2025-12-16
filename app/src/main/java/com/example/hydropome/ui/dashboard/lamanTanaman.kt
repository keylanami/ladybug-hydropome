package com.example.hydropome.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val PrimaryGreen = Color(0xFF4E9F80)
val TextBlack = Color(0xFF1E1E1E)
val TextGray = Color(0xFF888888)
val LightGrayBg = Color(0xFFF5F5F5)


@Composable
fun PlantDetailScreen() {
    Scaffold(
        bottomBar = { BottomFloatingButton() },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            PlantHeaderImage()

            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                PlantTitleSection()
                Spacer(modifier = Modifier.height(20.dp))
                DescriptionSection()
                Spacer(modifier = Modifier.height(20.dp))
                ToolsSection()
                Spacer(modifier = Modifier.height(20.dp))
                TutorialSection()
                // Extra space for bottom bar visibility inside scroll
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

// --- C O M P O N E N T S ---

@Composable
fun PlantHeaderImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        // --- BAGIAN YANG DIPERBAIKI ---
        // Ganti painterResource yang error dengan ColorPainter (Kotak Abu-abu)
        // Nanti kalau sudah ada foto asli, ganti jadi: painterResource(id = R.drawable.foto_kamu)
        Image(
            painter = ColorPainter(Color.LightGray),
            contentDescription = "Selada Hidroponik",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(BottomArcShape())
        )

        // Tombol Back
        IconButton(
            onClick = { /* Handle Back */ },
            modifier = Modifier
                .padding(top = 48.dp, start = 24.dp)
                .size(40.dp)
                .background(Color.White, CircleShape)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = TextBlack
            )
        }
    }
}

@Composable
fun PlantTitleSection() {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Selada Hidroponik",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Tag Mudah
            // Lingkaran manual
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color = PrimaryGreen, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Mudah",
                color = PrimaryGreen,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Tag Waktu
            Icon(
                imageVector = Icons.Default.DateRange, // Icon Kalender (pengganti jam)
                contentDescription = null,
                tint = TextGray,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "3–5 Ming",
                color = TextGray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun DescriptionSection() {
    Column {
        Text(
            text = "Deskripsi",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Selada merupakan salah satu tanaman paling populer dalam budidaya hidroponik karena pertumbuhannya yang cepat dan perawatannya yang mudah. Tanaman ini cocok untuk pemula karena tidak memerlukan banyak nutrisi khusus atau perawatan intensif. Selada tumbuh subur di sistem hidroponik seperti NFT (Nutrient Film Technique) dan dapat dipanen dalam waktu 3-5 minggu setelah tanam.",
            fontSize = 14.sp,
            color = TextGray,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun ToolsSection() {
    val tools = listOf(
        "Wadah atau Bak Tanam" to "Tempat air nutrisi dan tanaman diletakkan.",
        "Net Pot / Pot kecil berlubang" to "Untuk menahan tanaman dan media tanam.",
        "Spons/Rockwool" to "Media tanam tempat benih tumbuh.",
        "Pompa Air (untuk NFT)" to "Mengalirkan nutrisi secara sirkulasi.",
        "Penutup atau Styrofoam (untuk rakit apung)" to "Untuk menopang netpot.",
        "Alat ukur pH dan TDS" to "Untuk memantau kualitas larutan nutrisi.",
        "Benih selada" to "",
        "Nutrisi AB Mix" to "",
        "Air Bersih" to ""
    )

    Column {
        Text(
            text = "Alat dan Bahan",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.height(8.dp))

        tools.forEachIndexed { index, (item, desc) ->
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextBlack)) {
                        append("${index + 1}. $item")
                    }
                    if (desc.isNotEmpty()) {
                        withStyle(style = SpanStyle(color = TextGray)) {
                            append(" – $desc")
                        }
                    }
                },
                fontSize = 14.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun TutorialSection() {
    Column {
        Text(
            text = "Tutorial Menanam",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Box(contentAlignment = Alignment.Center) {
                    // --- BAGIAN YANG DIPERBAIKI ---
                    // Ganti thumbnail error dengan warna abu-abu gelap
                    Image(
                        painter = ColorPainter(Color.DarkGray),
                        contentDescription = "Tutorial Thumbnail",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )

                    // Tombol Play
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White.copy(alpha = 0.8f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = PrimaryGreen,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
                Text(
                    text = "Menanam Selada Hidroponik",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun BottomFloatingButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Button(
            onClick = { /* Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Mulai Tanam dan Pantau",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}


class BottomArcShape : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): androidx.compose.ui.graphics.Outline {
        return androidx.compose.ui.graphics.Outline.Generic(
            path = Path().apply {
                moveTo(0f, 0f)
                lineTo(0f, size.height - 40f) // Mulai lengkungan sedikit sebelum bawah
                quadraticBezierTo(
                    size.width / 2, size.height + 40f, // Titik kontrol lengkungan (bawah tengah)
                    size.width, size.height - 40f      // Titik akhir lengkungan
                )
                lineTo(size.width, 0f)
                close()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlantScreen() {
    PlantDetailScreen()
}