package com.example.biptesttask.presentation.command

sealed class WizardPageCommand : Command {

    object NavigateNext : WizardPageCommand()
    object NavigateBack : WizardPageCommand()
}