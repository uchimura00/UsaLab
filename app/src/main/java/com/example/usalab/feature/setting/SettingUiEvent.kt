package com.example.usalab.feature.setting

sealed interface SettingUiEvent {
    object OpenTerms : SettingUiEvent
    object OpenPrivacy : SettingUiEvent
    object OpenOssLicense : SettingUiEvent
}