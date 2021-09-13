package com.example.biptesttask.presentation.mappers

import com.example.biptesttask.presentation.models.WizardPageState
import java.lang.IllegalArgumentException

class SliderPageMapper {

    fun mapWizardPage(pageNumber: Int): WizardPageState =
        when (pageNumber) {
            0 -> WizardPageState.AutoNumber
            1 -> WizardPageState.DriverLicense
            else -> throw IllegalArgumentException()
        }
}