package com.example.biptesttask.presentation.viewmodels

import androidx.annotation.StringRes
import com.example.biptesttask.R
import com.example.biptesttask.presentation.models.WizardScreenState
import com.example.biptesttask.presentation.models.WizardPage

class WizardViewModel :
    SliderViewModel<WizardScreenState>(
        WizardScreenState()
    ) {

    fun onViewCreated(wizardPage: WizardPage) =
        updateScreenState(wizardPage = wizardPage)

    fun onNextButtonClicked() {
        if (model.errorMessage == null) {
            //save input text
            //navigateToNextWizardPageIfPossible() && updateScreenState()
            //call SliderFragment to change adapter
        } else {
            //hide keyboard
            //updateScreenState(errorMessage, inputText = "")
        }
        when (model.wizardPage) {
            WizardPage.DriverLicense ->
                updateScreenState(
                    wizardPage = WizardPage.DriverLicense,
                    headerTitleResId = R.string.tv_title_driver_license,
                    hintResId = R.string.hint_driver_license
                )
            WizardPage.AutoNumber ->
                updateScreenState(
                    wizardPage = WizardPage.AutoNumber,
                    headerTitleResId = R.string.tv_title_auto_registration_number,
                    hintResId = R.string.hint_auto_registration_number
                )
        }

    }

    fun onSkipButtonClicked() {
    }

    fun onInputTextChanged(text: CharSequence?) {
        // validate text which depends on screen state
    }

    private fun updateScreenState(
        wizardPage: WizardPage = model.wizardPage,
        inputText: String = model.inputText,
        @StringRes
        headerTitleResId: Int = model.headerTitleResId,
        @StringRes
        hintResId: Int = model.hintResId,
        errorMessage: String? = model.errorMessage,
        shouldRefreshView: Boolean = true
    ) {
        model = WizardScreenState(
            wizardPage,
            inputText,
            headerTitleResId,
            hintResId,
            errorMessage
        )
        if (shouldRefreshView) {
            refreshView()
        }
    }

    override fun moveToNextFragmentPage() {
        TODO("Not yet implemented")
    }
}