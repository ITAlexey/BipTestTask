package com.example.biptesttask.presentation.command

import com.example.biptesttask.presentation.models.WizardPageState

sealed class WizardPageCommand : Command {

    class NavigateNext(val pageState: WizardPageState) : WizardPageCommand()
    class NavigateBack(val pageState: WizardPageState) : WizardPageCommand()
}