package com.example.usalab.core.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainAppViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(MainAppUiState())
    val uiState = _uiState.asStateFlow()
}