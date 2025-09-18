package com.example.usalab.feature.memo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(MemoState())
    val uiState = _uiState.asStateFlow()
}