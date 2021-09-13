package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.biptesttask.databinding.FragmentItemWizardPageBinding
import com.example.biptesttask.presentation.adapters.WizardSliderAdapter.Companion.ARG_WIZARD_PAGE
import com.example.biptesttask.presentation.command.WizardPageCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.WizardPageScreenState
import com.example.biptesttask.presentation.viewmodels.WizardPageViewModel

class WizardPageFragment :
    BaseFragment<
            WizardPageScreenState,
            WizardPageCommand,
            WizardPageViewModel>(
        WizardPageViewModel::class.java
    ) {
    private val binding by viewBinding(FragmentItemWizardPageBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wizardPageNumber = arguments?.getInt(ARG_WIZARD_PAGE) ?: 0
        if (savedInstanceState == null) {
            viewModel.init(wizardPageNumber)
        }
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.apply {
            btnNext.setOnClickListener { viewModel.onNextButtonClicked() }
            btnSkip.setOnClickListener { viewModel.onSkipButtonClicked() }
            textInputEditText.addTextChangedListener(viewModel.initTextWatcher())
        }
    }

    override fun executeCommand(command: WizardPageCommand) =
        when (command) {
            is WizardPageCommand.NavigateToPage -> showAccordingPage(command.position);
            is WizardPageCommand.SwitchSliderAdapter -> changeAdapter()
        }

    private fun changeAdapter() =
        (parentFragment as SliderFragment).applyWalkthroughAdapter()

    private fun showAccordingPage(position: Int) =
        (parentFragment as SliderFragment).moveToAccordingPage(position)

    override fun renderView(model: WizardPageScreenState) {
        binding.tvTitleWizard.text = resources.getString(model.headerTitleResId)
        binding.textInputLayout.apply {
            isHintEnabled = model.isHintEnabled
            hint = resources.getString(model.hintResId)
            isEndIconVisible = model.isErrorIconVisible
            error = resources.getString(model.errorResId)
            isErrorEnabled = model.isErrorEnabled
        }
    }
}