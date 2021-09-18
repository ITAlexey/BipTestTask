package com.example.biptesttask.presentation.models

class SliderScreenState(
    val sliderPage: SliderPage
) {
    val isBottomViewVisible: Boolean = sliderPage is WalkthroughPageScreenState
    val isNextButtonVisible: Boolean = isBottomViewVisible
    val isDotsVisible: Boolean = isNextButtonVisible
    val isFinesButtonVisible =
        sliderPage is WizardPageScreenState && sliderPage.ordinalPageNumber == sliderPage.pageQuantity
    val isSwapActionEnabled: Boolean = sliderPage is WalkthroughPageScreenState
}