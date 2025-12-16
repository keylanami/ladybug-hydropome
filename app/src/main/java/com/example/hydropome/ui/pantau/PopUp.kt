package com.example.hydropome.ui.pantau

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

// --- WARNA (Sesuaikan dengan yang sudah ada) ---


@Composable
fun TaskCompletedDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    onNextDayClick: () -> Unit,
    onBackClick: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismissRequest) {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = Color.White,
                // --- BAGIAN INI DIUBAH SESUAI REQUEST UKURAN ---
                modifier = Modifier
                    .width(345.dp)  // Lebar 345
                    .height(329.dp) // Tinggi 329
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // Gunakan SpaceEvenly agar konten terbagi rata vertikal di dalam kotak
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(20.dp)
                ) {
                    // 1. Icon Centang (Saya kecilkan dikit biar muat di tinggi 329dp)
                    Box(
                        modifier = Modifier
                            .size(80.dp) // Diubah dari 100 ke 80 biar proporsional
                            .background(PrimaryGreen, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selesai",
                            tint = Color.White,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    // 2. Teks Judul
                    Text(
                        text = "Tugas Hari ke-1 Selesai \uD83C\uDF89", // Icon confetti
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    // 3. Tombol-tombol
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Tombol Hari Berikutnya
                        Button(
                            onClick = onNextDayClick,
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp) // Tinggi tombol sedikit disesuaikan
                        ) {
                            Text(
                                text = "Hari Berikutnya",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }

                        // Tombol Kembali
                        OutlinedButton(
                            onClick = onBackClick,
                            border = BorderStroke(1.dp, PrimaryGreen),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryGreen),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                        ) {
                            Text(
                                text = "Kembali",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewTaskCompletedDialog() {
    // State dummy untuk preview agar dialog muncul
    val showDialog = remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { showDialog.value = true }) {
            Text("Tampilkan Popup")
        }

        TaskCompletedDialog(
            showDialog = showDialog.value,
            onDismissRequest = { showDialog.value = false },
            onNextDayClick = { showDialog.value = false },
            onBackClick = { showDialog.value = false }
        )
    }
}