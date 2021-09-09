package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.models.WalkthroughScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class WalkthroughViewModel :
    SliderViewModel<WalkthroughScreenState>(
        WalkthroughScreenState()
    ) {

    override fun moveToNextFragmentPage() {
        TODO("Not yet implemented")
    }
}