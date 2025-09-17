package com.example.usalab.feature.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.usalab.core.AppState
import com.example.usalab.core.navigation.HomeRoute

fun NavGraphBuilder.homeScreen(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    composable<HomeRoute> {
        HomeScreen(
            appState = appState,
            modifier = modifier
        )
    }
}