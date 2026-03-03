package app.motion.android.ui.pantau

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.motion.android.R

// --- WARNA ---
val PrimaryGreen = Color(0xFF4E9F80)
val TextBlack = Color(0xFF1E1E1E)
val TextGray = Color(0xFF888888)
val LightGreenBg = Color(0xFFE8F5E9)
val OrangeProgress = Color(0xFFFFB74D) // Warna Orange Progress & Banner
val OrangeBg = Color(0xFFF79E45) // Warna Background Banner

@Composable
fun PlantTaskScreen() {
    Scaffold(
        topBar = { TaskTopBar() },
        containerColor = Color.White,
        bottomBar = { BottomActionButtons() } // Tombol Selesai & Panduan fixed di bawah
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Gambar Header Melengkung
            TaskHeaderImage()

            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                // 2. Judul & Info
                PlantInfoSection()

                Spacer(modifier = Modifier.height(20.dp))

                // 3. Card Progress
                ProgressCard()

                Spacer(modifier = Modifier.height(20.dp))
            }

            // 4. Selector Hari (Scroll Samping)
            DaySelectorSection()

            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Spacer(modifier = Modifier.height(20.dp))

                // 5. Checklist Tugas & Tips
                TaskChecklistCard()

                Spacer(modifier = Modifier.height(20.dp))

                // 6. Banner Marketplace
                MarketplaceBanner()

                // Spacer agar konten tidak tertutup bottom bar
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

// --- COMPONENTS ---

@Composable
fun TaskTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Back Action */ },
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color.LightGray, CircleShape)
        ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextBlack)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Pantau Tanaman",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.weight(1f))
        // Spacer kosong biar teks di tengah
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Composable
fun TaskHeaderImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = ColorPainter(Color.LightGray), // GANTI DENGAN GAMBAR ASLI
            contentDescription = "Tanaman Header",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(BottomCurveShape())
        )
    }
}

@Composable
fun PlantInfoSection() {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Selada Hidroponik",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Tag Mudah
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(PrimaryGreen, CircleShape)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Mudah", color = PrimaryGreen, fontSize = 14.sp)

            Spacer(modifier = Modifier.width(16.dp))

            // Tag Hari
            Icon(
                imageVector = Icons.Default.DateRange, // Placeholder Icon Daun
                contentDescription = null,
                tint = TextBlack,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Hari ke-1", color = TextBlack, fontSize = 14.sp)
        }
    }
}

@Composable
fun ProgressCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth(), // Padding horizontal dipindah ke parent (Screen) biar rapi
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            ) {
                // Judul
                Text(
                    text = "Progres Menanam",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        // fontFamily = PlusJakarta // Uncomment jika font sudah ada
                    ),
                    color = TextBlack
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Subtitle
                Text(
                    text = "Ayo mulai menanam!",
                    style = MaterialTheme.typography.bodyMedium, // Default font
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // --- PROGRESS BAR ---
                // Progress Bar Manual (Sesuai desain task)
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f) // Biar tidak mentok kanan
                        .height(8.dp)
                        .background(Color(0xFFFFE0B2), RoundedCornerShape(10.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.1f) // 10% progress
                            .fillMaxHeight()
                            .background(OrangeProgress, RoundedCornerShape(10.dp))
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "0% Selesai",
                    fontSize = 12.sp,
                    color = OrangeProgress,
                    fontWeight = FontWeight.Bold
                )
            }

            // Gambar Daun di Kanan Bawah
            // Menggunakan Icon sementara agar tidak error, ganti dengan R.drawable.daun nanti

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

@Composable
fun DaySelectorSection() {
    val days = listOf("01", "02", "03", "04", "05", "06")

    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(days) { index, day ->
            val isSelected = index == 0 // Hari pertama selected

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .size(50.dp) // Ukuran lingkaran
                    .background(
                        color = if (isSelected) PrimaryGreen else LightGreenBg,
                        shape = CircleShape
                    )
                    .clickable { }
            ) {
                Text(
                    text = "Hari",
                    fontSize = 10.sp,
                    color = if (isSelected) Color.White else PrimaryGreen
                )
                Text(
                    text = day,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else PrimaryGreen
                )
            }
        }
    }
}

@Composable
fun TaskChecklistCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp), // Shadow tipis
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth().border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header Tugas
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Red, modifier = Modifier.size(16.dp)) // Placeholder Pin
                Spacer(modifier = Modifier.width(8.dp))
                Text("Tugas Hari ke-1", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Checkbox Items
            TaskCheckboxItem("Siapkan Nutrisi & Air", true)
            TaskCheckboxItem("Rendam Rockwool", false)
            TaskCheckboxItem("Tanam Benih Selada", false)
            TaskCheckboxItem("Tutup & Simpan", false)

            Spacer(modifier = Modifier.height(16.dp))

            // Tips Section
            Row(verticalAlignment = Alignment.Top) {
                Icon(Icons.Default.Star, contentDescription = null, tint = PrimaryGreen, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Tips Hari Ini:", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Gunakan air tanpa kaporit untuk hasil terbaik!", fontSize = 12.sp, color = TextGray)
                }
            }
        }
    }
}

@Composable
fun TaskCheckboxItem(text: String, isChecked: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        // Custom Checkbox biar mirip desain (Kotak Hijau/Putih)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .background(if (isChecked) PrimaryGreen else Color.Transparent, RoundedCornerShape(6.dp))
                .border(1.dp, if (isChecked) PrimaryGreen else Color.LightGray, RoundedCornerShape(6.dp))
        ) {
            if (isChecked) {
                Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
            }
        }

        Spacer(modifier = Modifier.width(12.dp))
        Text(text, fontSize = 14.sp, color = TextBlack)
    }
}

@Composable
fun MarketplaceBanner() {
    Card(
        colors = CardDefaults.cardColors(containerColor = OrangeBg),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Belum punya alat dan bahan?", fontSize = 12.sp, color = Color.White.copy(alpha = 0.9f))
                Spacer(modifier = Modifier.height(4.dp))
                Text("Kunjungi Marketplace HydropoMe!", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White, lineHeight = 20.sp)
                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text("Belanja Sekarang", fontSize = 10.sp, color = Color.White)
                }
            }

            // Placeholder Image Produk
            Image(
                painter = ColorPainter(Color.White), // Ganti Gambar Kit Hidroponik
                contentDescription = "Produk",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun BottomActionButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryGreen),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Lihat Panduan", color = PrimaryGreen, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Hari ke-1 Selesai", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}

// Custom Shape untuk lengkungan gambar header
// Custom Shape untuk lengkungan gambar header
class BottomCurveShape : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): androidx.compose.ui.graphics.Outline {
        return androidx.compose.ui.graphics.Outline.Generic(
            path = Path().apply {
                moveTo(0f, 0f)
                lineTo(0f, size.height - 30f)

                // PERBAIKAN DI SINI:
                // Ganti quadraticBezierTo -> quadraticTo
                quadraticTo(
                    size.width / 2, size.height + 30f,
                    size.width, size.height - 30f
                )

                lineTo(size.width, 0f)
                close()
            }
        )
    }
}

@Preview(showBackground = true, heightDp = 1000)
@Composable
fun PreviewTaskScreen() {
    PlantTaskScreen()
}