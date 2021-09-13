package com.example.biptesttask.presentation.fragments.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.biptesttask.R
import com.example.biptesttask.presentation.App
import com.example.biptesttask.presentation.command.Command
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<
        ScreenState : Any,
        CommandType : Command,
        ViewModel : BaseViewModel<ScreenState, CommandType>> : Fragment() {

    protected lateinit var viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        subscribeToViewModelObservables()
    }

    private fun initViewModel() {
        val app = (requireActivity()).applicationContext as App
        val viewModelFactory = app.viewModelFactory
        val viewModelProvider = ViewModelProvider(this, viewModelFactory)
        viewModel = viewModelProvider.get(getViewModelClass())
    }

    abstract fun getViewModelClass(): Class<ViewModel>

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