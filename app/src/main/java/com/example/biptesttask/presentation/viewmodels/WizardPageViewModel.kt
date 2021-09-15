package com.example.biptesttask.presentation.viewmodels

import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.StringRes
import com.example.biptesttask.R
import com.example.biptesttask.data.repository.SharedPrefsEncrypted
import com.example.biptesttask.presentation.command.WizardPageCommand
import com.example.biptesttask.presentation.mappers.SliderPageMapper
import com.example.biptesttask.presentation.models.WizardPageScreenState
import com.example.biptesttask.presentation.models.WizardPageState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class WizardPageViewModel(
//    private val repository: SharedPrefsEncrypted,
    private val mapper: SliderPageMapper
) : BaseViewModel<
        WizardPageScreenState,
        WizardPageCommand>(
    WizardPageScreenState()
) {
    private var currentInputText: String = ""

    fun init(wizardPageNumber: Int) {
        val wizardPageState = mapper.mapWizardPage(wizardPageNumber)
        prepareFragmentPage(wizardPageState)
    }

    private fun prepareFragmentPage(
        wizardPageState: WizardPageState,
        shouldRefreshView: Boolean = true
    ) {
        when (wizardPageState) {
            WizardPageState.AutoNumber ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_auto_number,
                    hintResId = R.string.hint_auto_number,
                    shouldRefreshView = shouldRefreshView
                )
            WizardPageState.AutoRegistrationNumber ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_auto_registration_number,
                    hintResId = R.string.hint_auto_registration_number,
                    shouldRefreshView = shouldRefreshView
                )
            WizardPageState.DriverLicense ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_driver_license,
                    hintResId = R.string.hint_driver_license,
                    shouldRefreshView = shouldRefreshView
                )
        }
    }

    fun initTextWatcher(): TextWatcher =
        object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
                text.let {
                    val enteredText = text.toString()
                    if (enteredText.length < MAX_TEXT_LENGTH) {
                        currentInputText = enteredText
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        }

    fun onNextButtonClicked() =
        validateInputText()

    private fun validateInputText() =
        when {
            currentInputText.isNotEmpty() && currentInputText.length == model.getProperNumberLength() ->
                processSuccessCase()
            currentInputText.isNotEmpty() ->
                processErrorCase(R.string.error_incorrect_text)
            else ->
                processErrorCase(R.string.error_empty_text_field)
        }

    private fun processSuccessCase() {
        //need to map before saving
//        repository.saveData()
        val updatePageState = model.getNextWizardPageState()
        processFragmentTransition(updatePageState)
    }

    private fun processFragmentTransition(updatedPageState: WizardPageState) {
        executeCommand()
        prepareFragmentPage(
            wizardPageState = updatedPageState,
            shouldRefreshView = false
        )
    }


    private fun processErrorCase(@StringRes errorResId: Int) =
        updateScreenState(errorResId = errorResId)

    fun onSkipButtonClicked() {
    }

    private fun updateScreenState(
        wizardPageState: WizardPageState = model.wizardPageState,
        inputText: String = model.inputText,
        @StringRes
        headerTitleResId: Int = model.headerTitleResId,
        @StringRes
        hintResId: Int = model.hintResId,
        @StringRes
        errorResId: Int = model.errorResId,
        shouldRefreshView: Boolean = true
    ) {
        model = WizardPageScreenState(
            wizardPageState,
            inputText,
            headerTitleResId,
            hintResId,
            errorResId
        )
        if (shouldRefreshView) {
            refreshView()
        }
    }

    companion object {
        private const val MAX_TEXT_LENGTH = 8
        private const val EMPTY_LINE = ""
    }
}