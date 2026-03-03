package app.motion.android.ui.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.motion.android.R
import app.motion.android.ui.theme.PlusJakarta

@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
fun SearchBar() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(Color(0xFFD0D0D1), RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search_normal),
                contentDescription = "Search Icon",
                tint = Color(0xFF98A0AA),
                modifier = Modifier.width(24.dp).height(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Cari tanaman...",
                style = MaterialTheme.typography.bodyLarge.copy(fontFamily = PlusJakarta),
                color = Color(0xFF98A0AA)
            )
        }
    }
}

