package com.example.biptesttask.presentation.viewmodels.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.biptesttask.presentation.command.Command

abstract class BaseViewModel<
        ScreenState : Any,
        SupportedCommandType : Command>(
    initialState: ScreenState
) : ViewModel() {

    protected var model: ScreenState = initialState

    private val modelUpdateEvent = MutableLiveData<ScreenState>()
    private val commandsMutableLiveData = MutableLiveData<SupportedCommandType>()

    val modelUpdate: LiveData<ScreenState> = modelUpdateEvent
    val commandsLiveData: LiveData<SupportedCommandType> = commandsMutableLiveData

    protected fun executeCommand(command: SupportedCommandType) {
        commandsMutableLiveData.value = command
    }

    open fun onViewCreated() =
        Unit

    @CallSuper
    protected open fun refreshView() {
        modelUpdateEvent.value = model
    }
}