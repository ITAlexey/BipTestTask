package com.example.biptesttask.presentation.models

class WalkthroughPageScreenState(
    override val pageQuantity: Int = WALKTHROUGH_PAGE_QUANTITY,
    override val ordinalPageNumber: Int = 0
) : SliderPage{

    companion object {
        private const val WALKTHROUGH_PAGE_QUANTITY = 4
        private const val ZERO = 0
    }
}