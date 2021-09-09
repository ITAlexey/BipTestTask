package com.example.biptesttask.presentation.models

import androidx.annotation.StringRes
import com.example.biptesttask.R


class WizardScreenState(
    val wizardPage: WizardPage = WizardPage.AutoNumber,
    val inputText: String = "",
    @StringRes
    val headerTitleResId: Int = R.string.tv_title_driver_license,
    @StringRes
    val hintResId: Int = R.string.hint_driver_license,
    val errorMessage: String? = null
) : SliderScreenState {
    val isErrorIconVisible: Boolean = errorMessage != null
}