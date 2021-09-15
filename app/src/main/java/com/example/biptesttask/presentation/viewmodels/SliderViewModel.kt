package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.command.SliderCommand
import com.example.biptesttask.presentation.models.SliderAdapter
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class SliderViewModel : BaseViewModel<SliderScreenState, SliderCommand>(
    SliderScreenState()
) {

    override fun onViewCreated() {
        executeCommand(model.adapterType as SliderCommand)
        updateScreenState()
    }

    private fun updateScreenState(
        adapterType: SliderAdapter = model.adapterType,
        pageNumber: Int = model.pageNumber,
        pageQuantity: Int = model.pageQuantity,
        shouldRefreshView: Boolean = true
    ) {
        model = SliderScreenState(adapterType, pageNumber, pageQuantity)
        if (shouldRefreshView) {
            refreshView()
        }
    }

    fun onFinesButtonClicked() {
    }

    fun onArrowButtonClicked() {
    }

}