package com.example.biptesttask.presentation.viewmodels

import com.example.biptesttask.presentation.command.ProfileCommand
import com.example.biptesttask.presentation.models.ProfileScreenState
import com.example.biptesttask.presentation.viewmodels.base.BaseViewModel

class ProfileViewModel :
    BaseViewModel<
            ProfileScreenState,
            ProfileCommand>(
        ProfileScreenState()
    ) {
}