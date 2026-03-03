package app.motion.android.common.model

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val isMultipleChoice: Boolean = false
)
