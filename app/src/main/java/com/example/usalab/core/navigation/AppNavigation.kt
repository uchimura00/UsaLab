package com.example.usalab.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.usalab.core.AppState
import com.example.usalab.feature.home.homeScreen

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
    }
}