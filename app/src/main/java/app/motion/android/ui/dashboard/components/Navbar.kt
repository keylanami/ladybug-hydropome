package app.motion.android.ui.dashboard.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size // Import size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.motion.android.R

@Composable
fun HydropomeBottomNav() {
    var selectedItem by remember { mutableStateOf(0) }

    val primaryGreen = Color(0xFF179778)
    val grayInactive = Color(0xFF98A0AA)

    val items = listOf("Beranda", "Pantau Tanaman", "Marketplace", "Profil")

    val icons = listOf(
        R.drawable.home,
        R.drawable.ph_plant_fill,
        R.drawable.bag,
        R.drawable.profile_circle
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                ambientColor = Color(0x0F56585C),
                spotColor = Color(0x0F56585C)
            ),
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        items.forEachIndexed { index, title ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = icons[index]),
                        contentDescription = title,
                        modifier = Modifier.size(28.dp) // TAMBAHKAN INI UNTUK PERBESAR ICON
                    )
                },
                label = {
                    Text(
                        text = title,
                        fontSize = 12.sp,
                        fontWeight = if (selectedItem == index) FontWeight.SemiBold else FontWeight.Normal
                    )
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primaryGreen,
                    selectedTextColor = primaryGreen,
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = grayInactive,
                    unselectedTextColor = grayInactive
                )
            )
        }
    }
}