package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.widget.doOnTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.biptesttask.databinding.FragmentWizardBinding
import com.example.biptesttask.presentation.adapters.WizardAdapter.Companion.ARG_WIZARD_STATE
import com.example.biptesttask.presentation.models.WizardScreenState
import com.example.biptesttask.presentation.viewmodels.WizardViewModel

class WizardFragment(@LayoutRes layoutResId: Int) :
    SliderFragment<WizardScreenState, WizardViewModel>(
        layoutResId,
        WizardViewModel::class.java
    ) {
    private val binding by viewBinding(FragmentWizardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val state = arguments?.takeIf { it.containsKey(ARG_WIZARD_STATE) }?.run {
            getInt(ARG_WIZARD_STATE)
        } ?: 0
        setupView()
    }

    private fun setupView() {
        with(binding) {
            textInputEditText.doOnTextChanged { text, _, _, _ ->
                viewModel.onInputTextChanged(text)
            }
            btnNext.setOnClickListener { viewModel.onNextButtonClicked() }
            btnSkip.setOnClickListener { viewModel.onSkipButtonClicked() }
        }
    }

    override fun renderView(model: WizardScreenState) {
        updateTitle(model)
        updateTextInputLayout(model)
    }

    private fun updateTitle(model: WizardScreenState) {
//        binding.tvTitleWizard.text = resources.getString(model.headerTitleResId)
    }

    private fun updateTextInputLayout(model: WizardScreenState) {
        binding.textInputLayout.apply {
//            hint = resources.getString(model.hintResId)
//            error = resources.getString(model.error)
            isEndIconVisible = model.isErrorIconVisible
        }
    }
}