package com.example.biptesttask.presentation.viewmodels

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.StringRes
import com.example.biptesttask.R
import com.example.biptesttask.presentation.command.WizardPageCommand
import com.example.biptesttask.presentation.models.WizardPageScreenState
import com.example.biptesttask.presentation.models.WizardPageState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class WizardPageViewModel(
//    private val repository: SharedPrefsEncrypted,
) : BaseViewModel<
        WizardPageScreenState,
        WizardPageCommand>(
    WizardPageScreenState()
) {
    private var currentInputText: String = ""

    fun init(ordinalPageNumber: Int) {
        val wizardPageState = WizardPageState.getPageByOrdinal(ordinalPageNumber)
        prepareFragmentPage(wizardPageState)
    }

    private fun prepareFragmentPage(wizardPageState: WizardPageState) {
        when (wizardPageState) {
            WizardPageState.AutoNumber ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_auto_number,
                    hintResId = R.string.hint_auto_number,
                    shouldRefreshView = true
                )
            WizardPageState.AutoRegistrationNumber ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_auto_registration_number,
                    hintResId = R.string.hint_auto_registration_number,
                    shouldRefreshView = true
                )
            WizardPageState.DriverLicense ->
                updateScreenState(
                    wizardPageState = wizardPageState,
                    headerTitleResId = R.string.tv_title_driver_license,
                    hintResId = R.string.hint_driver_license,
                    shouldRefreshView = true
                )
        }
    }

    override fun onStart() =
        updateScreenState()

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

    fun onNextButtonClicked() {
        validateInputText()
    }

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
        executeCommand(WizardPageCommand.NavigateNext(model.wizardPageState))
    }

    private fun processErrorCase(@StringRes errorResId: Int) =
        updateScreenState(errorResId = errorResId)

    fun onSkipButtonClicked() =
        executeCommand(WizardPageCommand.NavigateBack(model.wizardPageState))

    private fun updateScreenState(
        pageQuantity: Int = model.pageQuantity,
        wizardPageState: WizardPageState = model.wizardPageState,
        ordinalPageNumber: Int = model.ordinalPageNumber,
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
            pageQuantity, wizardPageState,
            ordinalPageNumber, inputText,
            headerTitleResId, hintResId,
            errorResId
        )
        if (shouldRefreshView) {
            refreshView()
        }
    }

    companion object {
        private const val MAX_TEXT_LENGTH = 9
        private const val EMPTY_LINE = ""
    }
}