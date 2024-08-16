/*
package com.ecommerce.shared.main

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class MainViewModel (
    settingsRepository: SettingsRepository,
) : ScreenModel {

    val appTheme: StateFlow<Int?> = settingsRepository.getAppTheme().map { it }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = null,
    )

    val onBoardingCompleted: StateFlow<OnBoardingState> =
        settingsRepository.getUsername().map {
            OnBoardingState.Success(it.isNullOrEmpty().not())
        }.stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = OnBoardingState.Loading,
        )
}

sealed class OnBoardingState {
    data object Loading : OnBoardingState()
    data class Success(val completed: Boolean) : OnBoardingState()
}*/
