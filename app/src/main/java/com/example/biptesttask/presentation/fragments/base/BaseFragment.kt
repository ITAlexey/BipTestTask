package com.example.biptesttask.presentation.fragments.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

abstract class BaseFragment<
        ScreenState : Any,
        ViewModel : BaseViewModel<ScreenState>>(
    @LayoutRes val layoutResId: Int,
    viewModelClass: Class<ViewModel>
) : Fragment(layoutResId) {

    protected val viewModel: ViewModel by lazy { ViewModelProvider(this).get(viewModelClass) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModelObservables()
    }

    private fun subscribeToViewModelObservables() {
        val modelObserver = Observer<ScreenState>(this::renderView)
        viewModel.modelUpdate.observe(viewLifecycleOwner, modelObserver)
    }

    abstract fun renderView(model: ScreenState)

}