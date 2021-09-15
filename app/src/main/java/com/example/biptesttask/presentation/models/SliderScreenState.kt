package com.example.biptesttask.presentation.models

import com.example.biptesttask.presentation.command.SliderCommand

class SliderScreenState(
    val adapterType: SliderAdapter = SliderCommand.AdapterType.Wizard(),
    val pageNumber: Int = 0,
    val pageQuantity: Int = adapterType.pageQuantity
) {
    val isBottomViewVisible: Boolean = adapterType is SliderCommand.AdapterType.Wizard
    val isNextButtonVisible: Boolean = isBottomViewVisible
    val isDotsVisible: Boolean = isNextButtonVisible
    val isFinesButtonVisible =
        adapterType is SliderCommand.AdapterType.Walkthrough && pageNumber == pageQuantity - 1
    val isSwapActionEnabled: Boolean = adapterType is SliderCommand.AdapterType.Walkthrough
}