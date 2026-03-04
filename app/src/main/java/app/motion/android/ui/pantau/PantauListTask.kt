
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --- WARNA ---
val DarkGreenHeader = Color(0xFF15382B) // Hijau Gelap Header
val PrimaryGreen = Color(0xFF4E9F80)    // Hijau Tombol & Tag
val DangerRed = Color(0xFFD32F2F)       // Merah untuk tag Sulit
val SurfaceColor = Color(0xFFF8F9FA)    // Background abu sangat muda

@Composable
fun PlantListScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() },
        containerColor = SurfaceColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Header & Search Bar
            HeaderWithSearch()

            // 2. Daftar Tanamanmu
            Spacer(modifier = Modifier.height(16.dp))
            PlantSection(title = "Daftar Tanamanmu", isHistory = false)

            // 3. Riwayat
            Spacer(modifier = Modifier.height(16.dp))
            PlantSection(title = "Riwayat", isHistory = true)

            // Spacer bawah supaya tidak ketutup BottomBar
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// --- COMPONENTS ---

@Composable
fun HeaderWithSearch() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Background Hijau Gelap
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Tinggi Header
                .padding(bottom = 25.dp) // Memberi ruang untuk search bar menggantung
                .background(DarkGreenHeader)
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            // Di dalam HeaderWithSearch...
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Bagaimana Kabar\nTanamanmu Hari Ini?",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )
                // GANTI DI SINI (Hapus Eco, ganti DateRange atau icon lain)
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.3f),
                    modifier = Modifier.size(60.dp)
                )
            }
        }

        // Search Bar (Posisi menggantung/overlapping)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Cari tanaman kamu...",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun PlantSection(title: String, isHistory: Boolean) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Container Putih Pembungkus List
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                if (!isHistory) {
                    PlantItem(
                        name = "Selada Hidroponik",
                        difficulty = "Mudah",
                        day = "Hari ke-1",
                        isHard = false
                    )
                    HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                    PlantItem(
                        name = "Bayam Hidroponik",
                        difficulty = "Mudah",
                        day = "Hari ke-5",
                        isHard = false
                    )
                    HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                    PlantItem(
                        name = "Cabai Hidroponik",
                        difficulty = "Sulit",
                        day = "Hari ke-10",
                        isHard = true
                    )
                } else {
                    // Data Dummy Riwayat
                    PlantItem(
                        name = "Selada Hidroponik",
                        difficulty = "Mudah",
                        day = "Hari ke-1",
                        isHard = false
                    )
                    HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                    PlantItem(
                        name = "Bayam Hidroponik",
                        difficulty = "Mudah",
                        day = "Hari ke-5",
                        isHard = false
                    )
                }
            }
        }
    }
}

@Composable
fun PlantItem(name: String, difficulty: String, day: String, isHard: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Thumbnail Image
        Image(
            painter = ColorPainter(Color.LightGray), // GANTI DENGAN painterResource(R.drawable.foto)
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Info Tanaman
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(if (isHard) DangerRed else PrimaryGreen, CircleShape)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = difficulty,
                    fontSize = 12.sp,
                    color = if (isHard) DangerRed else PrimaryGreen
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = day,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        // Tombol Pantau
        Button(
            onClick = { /* Navigate */ },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Text(text = "Pantau", fontSize = 12.sp, color = Color.White)
        }
    }
}

@Composable
fun BottomNavBar() {
    @Composable
    fun BottomNavBar() {
        NavigationBar(
            containerColor = Color.White,
            tonalElevation = 8.dp
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
                label = { Text("Beranda", fontSize = 10.sp) },
                selected = false,
                onClick = {},
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                )
            )
            // ITEM 2: PANTAU TANAMAN
            NavigationBarItem(
                // GANTI ICON DI SINI (Eco -> DateRange)
                icon = { Icon(Icons.Default.DateRange, contentDescription = "Pantau") },
                label = { Text("Pantau Tanaman", fontSize = 10.sp) },
                selected = true,
                onClick = {},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryGreen,
                    selectedTextColor = PrimaryGreen,
                    indicatorColor = Color.White
                )
            )
            // ITEM 3: MARKETPLACE
            NavigationBarItem(
                // GANTI ICON DI SINI (ShoppingBag -> ShoppingCart)
                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Marketplace") },
                label = { Text("Marketplace", fontSize = 10.sp) },
                selected = false,
                onClick = {},
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                )
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
                label = { Text("Profil", fontSize = 10.sp) },
                selected = false,
                onClick = {},
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                )
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun PreviewPlantList() {
    PlantListScreen()
}