package com.example.biptesttask.presentation.models

import androidx.annotation.StringRes
import com.example.biptesttask.R

class WizardPageScreenState(
    override val pageQuantity: Int = WIZARD_PAGE_QUANTITY,
    val wizardPageState: WizardPageState = WizardPageState.AutoNumber,
    override val ordinalPageNumber: Int = wizardPageState.ordinal,
    val inputText: String = EMPTY_STRING,
    @StringRes
    val headerTitleResId: Int = R.string.tv_title_auto_number,
    @StringRes
    val hintResId: Int = R.string.hint_auto_number,
    @StringRes
    val errorResId: Int = R.string.error_incorrect_text
) : SliderPage {
    val isErrorEnabled: Boolean = inputText.isEmpty()
    val isErrorIconVisible: Boolean = isErrorEnabled
    val isHintEnabled: Boolean = inputText.isNotEmpty()

    fun getProperNumberLength(): Int =
        when (wizardPageState) {
            WizardPageState.DriverLicense -> DRIVER_LICENSE_LENGTH
            WizardPageState.AutoNumber -> AUTO_NUMBER_LENGTH
            WizardPageState.AutoRegistrationNumber -> AUTO_REGISTRATION_NUMBER_LENGTH
        }

    companion object {
        private const val AUTO_NUMBER_LENGTH = 8
        private const val DRIVER_LICENSE_LENGTH = 6
        private const val AUTO_REGISTRATION_NUMBER_LENGTH = 7
        private const val WIZARD_PAGE_QUANTITY = 3
        private const val EMPTY_STRING = ""
    }
}
