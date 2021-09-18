package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biptesttask.databinding.FragmentItemWizardPageBinding
import com.example.biptesttask.presentation.adapters.WizardSliderAdapter.Companion.ARG_WIZARD_PAGE
import com.example.biptesttask.presentation.command.WizardPageCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.WizardPageScreenState
import com.example.biptesttask.presentation.viewmodels.WizardPageViewModel

class WizardPageFragment :
    BaseFragment<WizardPageScreenState, WizardPageCommand, WizardPageViewModel>() {
    private lateinit var binding: FragmentItemWizardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemWizardPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            val ordinalPageNumber = arguments?.getInt(ARG_WIZARD_PAGE) ?: 0
            viewModel.init(ordinalPageNumber)
        }
        Log.d("SLIDER", "onViewCreated: ")
        setUpListeners()
    }

    private fun setUpListeners() =
        with(binding) {
            btnNext.setOnClickListener { viewModel.onNextButtonClicked() }
            btnSkip.setOnClickListener { viewModel.onSkipButtonClicked() }
            textInputEditText.addTextChangedListener(viewModel.initTextWatcher())
        }

//    override fun onStart() {
//        super.onStart()
//        viewModel.onStart()
//    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SLIDER", "onDestroy: WizardPageFragment")
    }

    override fun executeCommand(command: WizardPageCommand) {
        when (command) {
            is WizardPageCommand.NavigateNext ->
                (parentFragment as SliderFragment).moveToNextPage(command.pageState)
            is WizardPageCommand.NavigateBack ->
                (parentFragment as SliderFragment).moveToPreviousPage(command.pageState)
        }
    }

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

    override fun getViewModelClass(): Class<WizardPageViewModel> =
        WizardPageViewModel::class.java
}