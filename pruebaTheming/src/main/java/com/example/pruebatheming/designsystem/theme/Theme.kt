package com.example.pruebatheming.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme =
    darkColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40,
    )

private val jacketLightScheme = lightColorScheme(
    primary = jacketPrimaryLight,
    onPrimary = jacketOnPrimaryLight,
    primaryContainer = jacketPrimaryContainerLight,
    onPrimaryContainer = jacketOnPrimaryContainerLight,
    secondary = jacketSecondaryLight,
    onSecondary = jacketOnSecondaryLight,
    secondaryContainer = jacketSecondaryContainerLight,
    onSecondaryContainer = jacketOnSecondaryContainerLight,
    tertiary = jacketTertiaryLight,
    onTertiary = jacketOnTertiaryLight,
    tertiaryContainer = jacketTertiaryContainerLight,
    onTertiaryContainer = jacketOnTertiaryContainerLight,
    error = jacketErrorLight,
    onError = jacketOnErrorLight,
    errorContainer = jacketErrorContainerLight,
    onErrorContainer = jacketOnErrorContainerLight,
    background = jacketBackgroundLight,
    onBackground = jacketOnBackgroundLight,
    surface = jacketSurfaceLight,
    onSurface = jacketOnSurfaceLight,
    surfaceVariant = jacketSurfaceVariantLight,
    onSurfaceVariant = jacketOnSurfaceVariantLight,
    outline = jacketOutlineLight,
    outlineVariant = jacketOutlineVariantLight,
    scrim = jacketScrimLight,
    inverseSurface = jacketInverseSurfaceLight,
    inverseOnSurface = jacketInverseOnSurfaceLight,
    inversePrimary = jacketInversePrimaryLight,
)

private val jacketDarkScheme = darkColorScheme(
    primary = jacketPrimaryDark,
    onPrimary = jacketOnPrimaryDark,
    primaryContainer = jacketPrimaryContainerDark,
    onPrimaryContainer = jacketOnPrimaryContainerDark,
    secondary = jacketSecondaryDark,
    onSecondary = jacketOnSecondaryDark,
    secondaryContainer = jacketSecondaryContainerDark,
    onSecondaryContainer = jacketOnSecondaryContainerDark,
    tertiary = jacketTertiaryDark,
    onTertiary = jacketOnTertiaryDark,
    tertiaryContainer = jacketTertiaryContainerDark,
    onTertiaryContainer = jacketOnTertiaryContainerDark,
    error = jacketErrorDark,
    onError = jacketOnErrorDark,
    errorContainer = jacketErrorContainerDark,
    onErrorContainer = jacketOnErrorContainerDark,
    background = jacketBackgroundDark,
    onBackground = jacketOnBackgroundDark,
    surface = jacketSurfaceDark,
    onSurface = jacketOnSurfaceDark,
    surfaceVariant = jacketSurfaceVariantDark,
    onSurfaceVariant = jacketOnSurfaceVariantDark,
    outline = jacketOutlineDark,
    outlineVariant = jacketOutlineVariantDark,
    scrim = jacketScrimDark,
    inverseSurface = jacketInverseSurfaceDark,
    inverseOnSurface = jacketInverseOnSurfaceDark,
    inversePrimary = jacketInversePrimaryDark,
)

private val berlinLightScheme = lightColorScheme(
    primary = berlinPrimaryLight,
    onPrimary = berlinOnPrimaryLight,
    primaryContainer = berlinPrimaryContainerLight,
    onPrimaryContainer = berlinOnPrimaryContainerLight,
    secondary = berlinSecondaryLight,
    onSecondary = berlinOnSecondaryLight,
    secondaryContainer = berlinSecondaryContainerLight,
    onSecondaryContainer = berlinOnSecondaryContainerLight,
    tertiary = berlinTertiaryLight,
    onTertiary = berlinOnTertiaryLight,
    tertiaryContainer = berlinTertiaryContainerLight,
    onTertiaryContainer = berlinOnTertiaryContainerLight,
    error = berlinErrorLight,
    onError = berlinOnErrorLight,
    errorContainer = berlinErrorContainerLight,
    onErrorContainer = berlinOnErrorContainerLight,
    background = berlinBackgroundLight,
    onBackground = berlinOnBackgroundLight,
    surface = berlinSurfaceLight,
    onSurface = berlinOnSurfaceLight,
    surfaceVariant = berlinSurfaceVariantLight,
    onSurfaceVariant = berlinOnSurfaceVariantLight,
    outline = berlinOutlineLight,
    outlineVariant = berlinOutlineVariantLight,
    scrim = berlinScrimLight,
    inverseSurface = berlinInverseSurfaceLight,
    inverseOnSurface = berlinInverseOnSurfaceLight,
    inversePrimary = berlinInversePrimaryLight,
)

private val berlinDarkScheme = darkColorScheme(
    primary = berlinPrimaryDark,
    onPrimary = berlinOnPrimaryDark,
    primaryContainer = berlinPrimaryContainerDark,
    onPrimaryContainer = berlinOnPrimaryContainerDark,
    secondary = berlinSecondaryDark,
    onSecondary = berlinOnSecondaryDark,
    secondaryContainer = berlinSecondaryContainerDark,
    onSecondaryContainer = berlinOnSecondaryContainerDark,
    tertiary = berlinTertiaryDark,
    onTertiary = berlinOnTertiaryDark,
    tertiaryContainer = berlinTertiaryContainerDark,
    onTertiaryContainer = berlinOnTertiaryContainerDark,
    error = berlinErrorDark,
    onError = berlinOnErrorDark,
    errorContainer = berlinErrorContainerDark,
    onErrorContainer = berlinOnErrorContainerDark,
    background = berlinBackgroundDark,
    onBackground = berlinOnBackgroundDark,
    surface = berlinSurfaceDark,
    onSurface = berlinOnSurfaceDark,
    surfaceVariant = berlinSurfaceVariantDark,
    onSurfaceVariant = berlinOnSurfaceVariantDark,
    outline = berlinOutlineDark,
    outlineVariant = berlinOutlineVariantDark,
    scrim = berlinScrimDark,
    inverseSurface = berlinInverseSurfaceDark,
    inverseOnSurface = berlinInverseOnSurfaceDark,
    inversePrimary = berlinInversePrimaryDark,
)



enum class AppTheme {
    Berlin, Jacket
}

@Composable
fun CopilotDeckTheme(
    theme: AppTheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (theme) {
        AppTheme.Jacket -> if (darkTheme) jacketDarkScheme else jacketLightScheme
        AppTheme.Berlin -> if (darkTheme) berlinDarkScheme else berlinLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}