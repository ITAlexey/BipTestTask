package com.example.biptesttask.presentation.fragments.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.biptesttask.R
import com.example.biptesttask.presentation.command.Command
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<
        ScreenState : Any,
        CommandType : Command,
        ViewModel : BaseViewModel<ScreenState, CommandType>>(
    viewModelClass: Class<ViewModel>
) : Fragment() {

    protected val viewModel: ViewModel by lazy { ViewModelProvider(this).get(viewModelClass) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModelObservables()
    }

    private fun subscribeToViewModelObservables() {
        val modelObserver = Observer(this::renderView)
        viewModel.modelUpdate.observe(viewLifecycleOwner, modelObserver)
        val commandObserver = Observer(this::executeCommand)
        viewModel.commandsLiveData.observe(viewLifecycleOwner, commandObserver)
    }

    protected open fun executeCommand(command: CommandType) {
        showUnderDevelopmentMessage()
    }

    protected open fun renderView(model: ScreenState) {
        showUnderDevelopmentMessage()
    }

    private fun showUnderDevelopmentMessage() {
        view?.run {
            Snackbar.make(this, R.string.text_under_development, Snackbar.LENGTH_SHORT).show()
        }
    }
}