package app.motion.android.ui.personalisasi_user

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val isMultipleChoice: Boolean = false,
    val isImageOption: Boolean = false
)

@Composable
fun SurveyScreen() {
    // Page 1 questions
    val page1Questions = listOf(
        Question(
            id = 1,
            question = "Apakah kamu pernah mencoba menanam hidroponik sebelumnya?",
            options = listOf(
                "Belum pernah",
                "Pernah, tapi masih pemula",
                "Sudah cukup berpengalaman"
            ),
            isMultipleChoice = false
        ),
        Question(
            id = 2,
            question = "Apa tujuan utama kamu menggunakan aplikasi HydropoMe?",
            options = listOf(
                "Belajar hidroponik dari awal",
                "Merawat tanaman hidroponik yang sudah ada",
                "Membeli peralatan dan perlengkapan hidroponik",
                "Menjual hasil panen"
            ),
            isMultipleChoice = false
        )
    )

    // Page 2 questions
    val page2Questions = listOf(
        Question(
            id = 3,
            question = "Jenis tanaman apa saja yang ingin kamu tanam?",
            options = listOf(
                "Sayuran daun (misalnya selada, bayam)",
                "Buah (misalnya tomat, stroberi)",
                "Tanaman herbal",
                "Belum tahu / ingin rekomendasi"
            ),
            isMultipleChoice = true
        ),
        Question(
            id = 4,
            question = "Berapa waktu yang bisa diluangkan per hari untuk merawat tanaman?",
            options = listOf(
                "< 10 menit",
                "10-30 menit",
                "> 30 menit"
            ),
            isMultipleChoice = false
        ),
        Question(
            id = 5,
            question = "Dimana kamu akan menanam tanaman hidroponik?",
            options = listOf(
                "Dalam ruangan",
                "Luar ruangan",
                "Balkon atau teras"
            ),
            isMultipleChoice = false
        )
    )

    // Page 3 questions
    val page3Questions = listOf(
        Question(
            id = 6,
            question = "Berapa luas area tanam yang kamu miliki?",
            options = listOf(
                "< 1 m²",
                "1-3 m²",
                "> 3 m²"
            ),
            isMultipleChoice = false,
            isImageOption = true
        )
    )

    val allPages = listOf(page1Questions, page2Questions, page3Questions)
    var currentPage by remember { mutableStateOf(0) }
    var selectedAnswers by remember { mutableStateOf(mapOf<Int, String>()) }
    var selectedMultipleAnswers by remember { mutableStateOf(mapOf<Int, Set<String>>()) }
    var validationErrors by remember { mutableStateOf(setOf<Int>()) }
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    val currentQuestions = allPages[currentPage]

    // Reset scroll position when page changes
    LaunchedEffect(currentPage) {
        coroutineScope.launch {
            scrollState.animateScrollTo(0)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background dengan lengkungan
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height * 0.3f)
                quadraticBezierTo(
                    size.width / 2f,
                    size.height * 0.35f,
                    0f,
                    size.height * 0.3f
                )
                close()
            }
            drawPath(
                path = path,
                color = Color(0xFF2D5F5D)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { 
                        if (currentPage > 0) {
                            currentPage--
                        }
                    },
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "${currentPage + 1}/3",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    TextButton(
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(16.dp)),
                        onClick = { /* Handle lewati */ },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White
                        )
                    ) {
                        Text("Lewati", fontSize = 14.sp)
                    }
                }
            }

            // Title
            Text(
                text = "Yuk Jawab Biar HydropoMe\nTahu Kebutuhanmu 💚",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                lineHeight = 32.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Content Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .verticalScroll(scrollState)
                ) {
                    currentQuestions.forEach { question ->
                        QuestionSection(
                            question = question,
                            selectedAnswer = selectedAnswers[question.id],
                            selectedMultipleAnswers = selectedMultipleAnswers[question.id] ?: emptySet(),
                            hasError = validationErrors.contains(question.id),
                            onAnswerSelected = { answer ->
                                selectedAnswers = selectedAnswers + (question.id to answer)
                                validationErrors = validationErrors - question.id
                            },
                            onMultipleAnswerToggled = { answer ->
                                val currentAnswers = selectedMultipleAnswers[question.id] ?: emptySet()
                                val newAnswers = if (currentAnswers.contains(answer)) {
                                    currentAnswers - answer
                                } else {
                                    currentAnswers + answer
                                }
                                selectedMultipleAnswers = selectedMultipleAnswers + (question.id to newAnswers)
                                if (newAnswers.isNotEmpty()) {
                                    validationErrors = validationErrors - question.id
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Button Selanjutnya or Simpan
                    Button(
                        onClick = { 
                            // Validate current page
                            val errors = mutableSetOf<Int>()
                            currentQuestions.forEach { question ->
                                val isAnswered = if (question.isMultipleChoice) {
                                    selectedMultipleAnswers[question.id]?.isNotEmpty() == true
                                } else {
                                    selectedAnswers[question.id] != null
                                }
                                if (!isAnswered) {
                                    errors.add(question.id)
                                }
                            }
                            
                            if (errors.isEmpty()) {
                                if (currentPage < 2) {
                                    currentPage++
                                } else {
                                    // Handle save/submit
                                }
                            } else {
                                validationErrors = errors
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2D5F5D)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (currentPage < 2) "Selanjutnya" else "Simpan",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun QuestionSection(
    question: Question,
    selectedAnswer: String?,
    selectedMultipleAnswers: Set<String>,
    hasError: Boolean = false,
    onAnswerSelected: (String) -> Unit,
    onMultipleAnswerToggled: (String) -> Unit
) {
    Column {
        // Icon and Question
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Plant icon placeholder
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("🌱", fontSize = 20.sp)
            }

            Text(
                text = question.question,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.weight(1f),
                lineHeight = 22.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Options
        question.options.forEach { option ->
            if (question.isImageOption) {
                ImageOptionItem(
                    text = option,
                    isSelected = selectedAnswer == option,
                    onClick = { onAnswerSelected(option) }
                )
            } else if (question.isMultipleChoice) {
                CheckboxOptionItem(
                    text = option,
                    isChecked = selectedMultipleAnswers.contains(option),
                    onClick = { onMultipleAnswerToggled(option) }
                )
            } else {
                OptionItem(
                    text = option,
                    isSelected = selectedAnswer == option,
                    onClick = { onAnswerSelected(option) }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        
        // Error message
        if (hasError) {
            Text(
                text = "*Opsi wajib dipilih",
                fontSize = 14.sp,
                color = Color(0xFFD32F2F),
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }
    }
}

@Composable
fun OptionItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = if (isSelected) Color(0xFF2D5F5D) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = if (isSelected) Color(0xFFE8F5E9) else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF2D5F5D),
                unselectedColor = Color(0xFFBDBDBD)
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF424242),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun CheckboxOptionItem(
    text: String,
    isChecked: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = if (isChecked) Color(0xFF2D5F5D) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = if (isChecked) Color(0xFFE8F5E9) else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF2D5F5D),
                uncheckedColor = Color(0xFFBDBDBD),
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF424242),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ImageOptionItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = if (isSelected) Color(0xFF2D5F5D) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = if (isSelected) Color(0xFFE8F5E9) else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF2D5F5D),
                unselectedColor = Color(0xFFBDBDBD)
            )
        )
        
        // Image placeholder (3D isometric box)
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = Color(0xFF7CB342).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            // Simple representation of area size
            val size = when {
                text.contains("< 1") -> 40.dp
                text.contains("1-3") -> 55.dp
                else -> 70.dp
            }
            Box(
                modifier = Modifier
                    .size(size)
                    .background(
                        color = Color(0xFF7CB342),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
        
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF424242),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SurveyScreenPreview() {
    SurveyScreen()
}
