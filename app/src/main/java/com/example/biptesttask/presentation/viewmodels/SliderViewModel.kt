package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.command.WizardSliderCommand
import com.example.biptesttask.presentation.mappers.SliderPageMapper
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class SliderViewModel(
    private val mapper: SliderPageMapper
) : BaseViewModel<SliderScreenState, WizardSliderCommand>(
        SliderScreenState()
    ) {
}