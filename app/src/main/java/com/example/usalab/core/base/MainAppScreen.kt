package com.example.usalab.core.base

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.usalab.core.AppState
import com.example.usalab.core.navigation.AppNavigation

@Composable
fun MainAppScreen(
    appState: AppState,
    modifier: Modifier = Modifier,
    viewModel: MainAppViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    fun eventHandler(event: MainAppUiEvent) {
    }

    Scaffold(modifier) { innerPadding ->
        AppNavigation(
            appState = appState,
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        )
    }
}