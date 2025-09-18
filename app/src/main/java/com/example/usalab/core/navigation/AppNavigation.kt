package com.example.usalab.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.usalab.core.AppState
import com.example.usalab.feature.home.homeScreen
import com.example.usalab.feature.memo.memoScreen
import com.example.usalab.feature.setting.settingScreen

@Composable
fun AppNavigation(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        homeScreen(appState = appState, modifier = modifier)
        settingScreen(appState = appState, modifier = modifier)
        memoScreen(appState = appState, modifier = modifier)
    }
}