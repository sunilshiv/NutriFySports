package com.nutrifysports.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.nutrifysports.shared.resources.Res
import com.nutrifysports.shared.resources.bebas_neue_regular
import com.nutrifysports.shared.resources.roboto_condensed_medium
import org.jetbrains.compose.resources.Font

@Composable
fun BebasNeueFontFamily(): FontFamily { // Renamed for clarity, returns FontFamily
    return FontFamily(
        Font(Res.font.bebas_neue_regular)
    )
}

@Composable
fun RobotoCondensedFontFamily() = FontFamily(
    Font(Res.font.roboto_condensed_medium)
)

object FontSize {
    val EXTRA_SMALL = 10.sp
    val SMALL = 10.sp
    val REGULAR = 14.sp
    val EXTRA_REGULAR = 16.sp
    val MEDIUM = 18.sp
    val EXTRA_MEDIUM = 20.sp
    val LARGE = 30.sp
    val EXTRA_LARGE = 40.sp
}