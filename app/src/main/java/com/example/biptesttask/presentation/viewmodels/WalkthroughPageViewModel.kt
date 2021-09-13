package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.command.WalkthroughPageCommand
import com.example.biptesttask.presentation.models.WalkthroughPageScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class WalkthroughPageViewModel :
    BaseViewModel<
            WalkthroughPageScreenState,
            WalkthroughPageCommand>(
        WalkthroughPageScreenState()
    ) {
}