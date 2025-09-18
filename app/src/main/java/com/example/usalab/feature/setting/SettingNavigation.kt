package com.example.usalab.feature.setting

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.usalab.core.AppState
import com.example.usalab.core.navigation.SettingRoute

fun NavGraphBuilder.settingScreen(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    composable<SettingRoute> {
        SettingScreen(
            appState = appState,
            modifier = modifier
        )
    }
}