package com.example.biptesttask.presentation.command

import com.example.biptesttask.presentation.models.SliderAdapter


sealed class SliderCommand : SliderAdapter {
    sealed class AdapterType : SliderCommand() {
        class Wizard(
            override val pageQuantity: Int = WIZARD_PAGE_QUANTITY
        ) : AdapterType()

        class Walkthrough(
            override val pageQuantity: Int = WALKTHROUGH_PAGE_QUANTITY
        ) : AdapterType()
    }

    companion object {
        private const val WIZARD_PAGE_QUANTITY = 3
        private const val WALKTHROUGH_PAGE_QUANTITY = 3
    }
}