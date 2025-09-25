package com.example.usalab.core.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute
@Serializable
data object SettingRoute
@Serializable
data class MemoRoute(val memoId: Int? = null)