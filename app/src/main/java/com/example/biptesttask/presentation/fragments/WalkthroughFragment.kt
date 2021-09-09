package com.example.biptesttask.presentation.fragments

import androidx.annotation.LayoutRes
import com.example.biptesttask.presentation.models.WalkthroughScreenState
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.viewmodels.WalkthroughViewModel

class WalkthroughFragment(@LayoutRes layoutResId: Int) :
    SliderFragment<
            WalkthroughScreenState,
            WalkthroughViewModel>(
        layoutResId,
        WalkthroughViewModel::class.java
    ) {

    override fun renderView(model: WalkthroughScreenState) {

    }
}