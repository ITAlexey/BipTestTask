package com.example.biptesttask.presentation.command

sealed class WizardPageCommand : Command {

    class NavigateToPage(val position: Int) : WizardPageCommand()
    object SwitchSliderAdapter : WizardPageCommand()
}