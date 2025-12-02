package com.example.hydropome.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hydropome.ui.common.component.AuthTextField
import com.example.hydropome.ui.theme.green

@Composable
@Preview
fun RegisterScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .systemBarsPadding()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Daftar Akun dan Mulai Bertani Hidroponik! 🌿",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(40.dp))

        AuthTextField(
            label = "Nama Lengkap",
            placeholder = "Masukkan Nama Lengkap",
            value = name,
            onValueChange = { name = it }
        )

        Spacer(Modifier.height(16.dp))

        AuthTextField(
            label = "Email",
            placeholder = "Masukkan Email",
            value = email,
            onValueChange = { email = it }
        )

        Spacer(Modifier.height(16.dp))

        AuthTextField(
            label = "Buat Password",
            placeholder = "Masukkan Password",
            isPassword = true,
            value = password,
            onValueChange = { password = it }
        )

        Spacer(Modifier.height(16.dp))

        AuthTextField(
            label = "Konfirmasi Password",
            placeholder = "Masukkan Password",
            isPassword = true,
            value = confirmPassword,
            onValueChange = { confirmPassword = it }
        )

        Spacer(Modifier.height(40.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = green,
                contentColor = Color.White
            )
        ) {
            Text("Daftar Akun")
        }

        Spacer(Modifier.height(16.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sudah memiliki akun? ",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Masuk",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = green
            )
        }
    }
}
