package com.chichi289.sentiview.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

private val typography = Typography().run {
    copy(
        headlineLarge = headlineLarge.copy(
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp
        ),
        headlineMedium = headlineMedium.copy(
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = titleLarge.copy(
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = titleMedium.copy(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.0125.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal
        ),
        titleSmall = titleSmall.copy(
            fontSize = 16.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.0125.sp
        ),
        bodyLarge = bodyLarge.copy(
            fontSize = 16.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.0125.sp
        ),
        bodyMedium = bodyMedium.copy(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.0107.sp
        ),
        bodySmall = bodySmall.copy(
            fontSize = 13.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.0192.sp
        ),
        labelLarge = labelLarge.copy(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.0107.sp
        ),
        labelMedium = labelMedium.copy(
            fontSize = 13.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.0192.sp
        ),
        labelSmall = labelSmall.copy(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.025.sp
        )
    )
}
val InterFontFamily = FontFamily(
    fonts = listOf(
        Font(R.font.inter_thin, FontWeight.Thin),
        Font(R.font.inter_extra_light, FontWeight.ExtraLight),
        Font(R.font.inter_light, FontWeight.Light),
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_medium, FontWeight.Medium),
        Font(R.font.inter_semi_bold, FontWeight.SemiBold),
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
        Font(R.font.inter_black, FontWeight.Black)
    )
)