package com.hishabee.kotlin_test.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val SlateGrey = Color(0xFF35373A)
val DuskBlue = Color(0xFF28397E)
val GreyWhite = Color(0xFFD5D5D5)
val GreyWhite3 = Color(0xFFF8F8F8)
val BlueGreen = Color(0xFF05A781)
val IcedBlue = Color(0xFFF2F5FF)
val VeryPaleGreen = Color(0xFFEBFCE0)
val White = Color(0xFFFFFFFF)
val Onyx = Color(0xFF35373A)


val replyLightPrimary = Color(0xFF383838)
val replyLightOnPrimary = Color(0xFFFFFFFF)
val replyLightPrimaryContainer = Color(0xFFFFDDAE)
val replyLightOnPrimaryContainer = Color(0xFF2A1800)
val replyLightSecondary = Color(0xFF6F5B40)
val replyLightOnSecondary = Color(0xFFFFFFFF)
val replyLightSecondaryContainer = Color(0xFFFADEBC)
val replyLightOnSecondaryContainer = Color(0xFF271904)
val replyLightTertiary = Color(0xFF516440)
val replyLightOnTertiary = Color(0xFFFFFFFF)
val replyLightTertiaryContainer = Color(0xFFD3EABC)
val replyLightOnTertiaryContainer = Color(0xFF102004)
val replyLightError = Color(0xFFBA1B1B)
val replyLightErrorContainer = Color(0xFFFFDAD4)
val replyLightOnError = Color(0xFFFFFFFF)
val replyLightOnErrorContainer = Color(0xFF410001)
val replyLightBackground = Color(0xFFFFFFFF)
val replyLightOnBackground = Color(0xFF1F1B16)
val replyLightSurface = Color(0xFFFCFCFC)
val replyLightOnSurface = Color(0xFF1F1B16)
val replyLightSurfaceVariant = Color(0xFFF0E0CF)
val replyLightOnSurfaceVariant = Color(0xFF4F4539)
val replyLightOutline = Color(0xFF817567)
val replyLightInverseOnSurface = Color(0xFFF9EFE6)
val replyLightInverseSurface = Color(0xFF34302A)
val replyLightPrimaryInverse = Color(0xFFFFB945)

val replyDarkPrimary = Color(0xFFFFFFFF)
val replyDarkOnPrimary = Color(0xFF452B00)
val replyDarkPrimaryContainer = Color(0xFF624000)
val replyDarkOnPrimaryContainer = Color(0xFFFFDDAE)
val replyDarkSecondary = Color(0xFFDDC3A2)
val replyDarkOnSecondary = Color(0xFF3E2E16)
val replyDarkSecondaryContainer = Color(0xFF56442B)
val replyDarkOnSecondaryContainer = Color(0xFFFADEBC)
val replyDarkTertiary = Color(0xFFB8CEA2)
val replyDarkOnTertiary = Color(0xFF243516)
val replyDarkTertiaryContainer = Color(0xFF3A4C2B)
val replyDarkOnTertiaryContainer = Color(0xFFD3EABC)
val replyDarkError = Color(0xFFFFB4A9)
val replyDarkErrorContainer = Color(0xFF930006)
val replyDarkOnError = Color(0xFF680003)
val replyDarkOnErrorContainer = Color(0xFFFFDAD4)
val replyDarkBackground = Color(0xFF1F1B16)
val replyDarkOnBackground = Color(0xFFEAE1D9)
val replyDarkSurface = Color(0xFF1F1B16)
val replyDarkOnSurface = Color(0xFFEAE1D9)
val replyDarkSurfaceVariant = Color(0xFF4F4539)
val replyDarkOnSurfaceVariant = Color(0xFFD3C4B4)
val replyDarkOutline = Color(0xFF9C8F80)
val replyDarkInverseOnSurface = Color(0xFF32281A)
val replyDarkInverseSurface = Color(0xFFEAE1D9)
val replyDarkPrimaryInverse = Color(0xFF624000)


@Composable
fun colorPatternOffWhite():Color = if(isSystemInDarkTheme()) White else Onyx

@Composable
fun colorPatternBlackWhite():Color = if(isSystemInDarkTheme()) Color.Black else White