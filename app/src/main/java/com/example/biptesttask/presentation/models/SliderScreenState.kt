package com.example.biptesttask.presentation.models

class SliderScreenState(
    val currentSlider: SliderAdapterType,
    val pagePosition: Int = 0,
    val maxPageNumber: Int,
    val isSwapTransitionEnabled: Boolean = false
) {
    val isBottomViewVisible: Boolean = currentSlider == SliderAdapterType.Wizard
    val isNextButtonVisible: Boolean = isBottomViewVisible
    val isDotsVisible: Boolean = isNextButtonVisible
    val isFinesButtonVisible =
        currentSlider == SliderAdapterType.Walkthrough && pagePosition == maxPageNumber - 1
}