package com.example.biptesttask.presentation.command


sealed class SliderCommand : Command {
    sealed class AdapterType : SliderCommand() {
        object Wizard : AdapterType()
        object Walkthrough : AdapterType()
    }
    sealed class Navigation : SliderCommand() {
        object ToNextPage : Navigation()
        object ToProfile : Navigation()
    }
}