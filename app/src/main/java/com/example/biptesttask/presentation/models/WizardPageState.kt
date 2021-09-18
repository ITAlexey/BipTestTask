package com.example.biptesttask.presentation.models


enum class WizardPageState {
    AutoNumber,
    AutoRegistrationNumber,
    DriverLicense;

    companion object {
        fun getPageByOrdinal(ordinal: Int): WizardPageState =
            values()[ordinal]
    }
}