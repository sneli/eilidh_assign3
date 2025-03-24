package com.example.eilidh_assign3.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eilidh_assign3.R

val YourGrace = FontFamily(
    Font(R.font.coveredbyyourgrace_regular)
)

val RedHat = FontFamily(
    Font(R.font.redhattext_regular),
    Font(R.font.redhattext_italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = YourGrace,
        fontSize = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = RedHat,
        fontStyle = FontStyle.Italic,
        fontSize = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RedHat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = RedHat,
        fontSize = 16.sp
    )
)