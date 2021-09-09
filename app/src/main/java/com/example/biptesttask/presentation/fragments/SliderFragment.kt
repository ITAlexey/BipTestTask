package com.example.biptesttask.presentation.fragments

import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.SliderViewModel

abstract class SliderFragment<
        ScreenState : SliderScreenState,
        ViewModel : SliderViewModel<ScreenState>>(
    @LayoutRes layoutResId: Int,
    viewModelClass: Class<ViewModel>
) : BaseFragment<ScreenState, ViewModel>(
    layoutResId,
    viewModelClass
) {

    @CallSuper
    override fun renderView(model: ScreenState) {
        showFragmentPage()
    }

    abstract fun showFragmentPage()
}