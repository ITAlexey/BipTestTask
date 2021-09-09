package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

abstract class SliderViewModel<FragmentScreenState : SliderScreenState>(
    initialScreenState: FragmentScreenState
) : BaseViewModel<FragmentScreenState>(
    initialScreenState
) {

    abstract fun moveToNextFragmentPage()

}