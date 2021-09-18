package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.command.SliderCommand
import com.example.biptesttask.presentation.models.SliderPage
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.models.WalkthroughPageScreenState
import com.example.biptesttask.presentation.models.WizardPageScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel
import java.lang.IllegalArgumentException

class SliderViewModel : BaseViewModel<SliderScreenState, SliderCommand>(
    SliderScreenState(WizardPageScreenState())
) {

    override fun onViewCreated() {
        executeCommand(getAdapterType())
    }

    private fun getAdapterType(): SliderCommand =
        when (model.sliderPage) {
            is WizardPageScreenState -> SliderCommand.AdapterType.Wizard
            is WalkthroughPageScreenState -> SliderCommand.AdapterType.Walkthrough
            else -> throw IllegalArgumentException()
        }

    private fun updateScreenState(
        sliderPage: SliderPage = model.sliderPage,
        shouldRefreshView: Boolean = true
    ) {
        model = SliderScreenState(sliderPage)
        if (shouldRefreshView) {
            refreshView()
        }
    }

    fun onFinesButtonClicked() {
    }

    fun onArrowButtonClicked() {
    }

//    fun onPageTransition(ordinalPageNumber: Int) {
//        //find out adapter,
//        executeCommand()
//        updateScreenState()
//    }

}