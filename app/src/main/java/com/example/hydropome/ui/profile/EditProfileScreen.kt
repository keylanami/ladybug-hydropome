package com.example.hydropome.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.hydropome.common.model.profile.Profile
import com.example.hydropome.ui.common.component.AuthTextField
import com.example.hydropome.ui.theme.green

@Composable
@Preview
fun EditProfileScreen() {
    var profile by remember {
        mutableStateOf(
            Profile(
                username = "Admin",
                email = "admin@gmail.com",
                password = ""
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(40.dp)
                    .border(1.dp, Color(0xFFE0E0E0), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Edit Profil",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(Modifier.height(20.dp))

        Box {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFE0E0E0), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(60.dp)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = (-4).dp, y = (-4).dp)
                    .size(32.dp)
                    .background(green, shape = CircleShape)
                    .border(2.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(Modifier.height(30.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            AuthTextField (
                label = "Nama Lengkap",
                placeholder = "Masukkan Nama",
                value = profile.username,
                onValueChange = { profile.username = it }
            )

            Spacer(Modifier.height(16.dp))

            AuthTextField(
                label = "Email",
                placeholder = "Masukkan Email",
                value = profile.email,
                onValueChange = { profile.email = it }
            )

            Spacer(Modifier.height(16.dp))

            AuthTextField(
                label = "Password",
                placeholder = "Masukkan Password",
                value = profile.password,
                onValueChange = { profile.password = it },
                isPassword = true
            )

            Spacer(Modifier.height(16.dp))

            AuthTextField(
                label = "Ubah Password",
                placeholder = "Masukkan Password Baru",
                value = profile.password,
                onValueChange = { profile.password = it },
                isPassword = true
            )

            Spacer(Modifier.height(50.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = green,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Simpan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(30.dp))
        }
    }
}