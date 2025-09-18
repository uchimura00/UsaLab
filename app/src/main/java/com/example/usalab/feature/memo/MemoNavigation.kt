package com.example.usalab.feature.memo

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.usalab.core.AppState
import com.example.usalab.core.navigation.MemoRoute

fun NavGraphBuilder.memoScreen(
    appState: AppState,
    modifier: Modifier = Modifier
) {
    composable<MemoRoute> {
        MemoScreen(
            appState = appState,
            modifier = modifier
        )
    }
}