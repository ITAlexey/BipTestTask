package com.example.biptesttask.presentation.viewmodels.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ScreenState : Any>(
    initialState: ScreenState
) : ViewModel() {

    protected var model: ScreenState = initialState

    private val modelUpdateEvent = MutableLiveData<ScreenState>()
    val modelUpdate: LiveData<ScreenState> = modelUpdateEvent

    open fun onViewCreated() =
        Unit

    @CallSuper
    protected open fun refreshView() {
        modelUpdateEvent.value = model
    }

}