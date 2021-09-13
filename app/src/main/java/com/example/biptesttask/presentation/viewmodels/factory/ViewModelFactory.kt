package com.example.biptesttask.presentation.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.biptesttask.presentation.mappers.SliderPageMapper
import com.example.biptesttask.presentation.viewmodels.ProfileViewModel
import com.example.biptesttask.presentation.viewmodels.SliderViewModel
import com.example.biptesttask.presentation.viewmodels.WalkthroughPageViewModel
import com.example.biptesttask.presentation.viewmodels.WizardPageViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when (modelClass) {
            ProfileViewModel::class.java -> ProfileViewModel() as T;
            SliderViewModel::class.java -> SliderViewModel() as T;
            WalkthroughPageViewModel::class.java -> WalkthroughPageViewModel() as T
            WizardPageViewModel::class.java -> WizardPageViewModel(SliderPageMapper()) as T
            else -> throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
        }
}