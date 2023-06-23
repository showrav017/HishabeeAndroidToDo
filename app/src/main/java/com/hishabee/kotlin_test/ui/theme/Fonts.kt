package com.hishabee.kotlin_test.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.hishabee.kotlin_test.R

val AppFonts = FontFamily(
    Font(R.font.regular, weight = FontWeight.Normal),
    Font(R.font.italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.light, weight = FontWeight.Light),
    Font(R.font.light_italic, weight = FontWeight.Light, style = FontStyle.Italic),

    Font(R.font.medium, weight = FontWeight.Medium),
    Font(R.font.medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.thin, weight = FontWeight.Thin),
    Font(R.font.thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),

    Font(R.font.bold, weight = FontWeight.Bold),
    //Font(R.font.semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.black, weight = FontWeight.Black),
    Font(R.font.black_italic, weight = FontWeight.Black, style = FontStyle.Italic),

    //Font(R.font.extra_bold, weight = FontWeight.ExtraBold),
    //Font(R.font.extra_light, weight = FontWeight.ExtraLight),
)