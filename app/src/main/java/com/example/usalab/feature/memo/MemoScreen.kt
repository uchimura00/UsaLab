package com.example.usalab.feature.memo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.usalab.core.AppState
import com.example.usalab.ui.theme.UsaLabTheme

@Composable
fun MemoScreen(
    appState: AppState,
    modifier: Modifier = Modifier,
    viewModel: MemoViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    fun eventHandler(event: MemoUiEvent) {
    }

    Scaffold(modifier) { innerPadding ->
        MemoTemplate(
            uiState = uiState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            eventHandler = {
                eventHandler(it)
            },
        )
    }
}

@Composable
fun MemoTemplate(
    uiState: MemoState,
    eventHandler: (MemoUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
private fun MemoScreenPreview() {
    UsaLabTheme {
        MemoTemplate(
            uiState = MemoState(),
            eventHandler = {},
        )
    }
}