package com.example.biptesttask.presentation.fragments

import com.example.biptesttask.presentation.command.ProfileCommand
import com.example.biptesttask.presentation.models.ProfileScreenState
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.viewmodels.ProfileViewModel

class ProfileFragment : BaseFragment<
        ProfileScreenState,
        ProfileCommand,
        ProfileViewModel>(
) {
    override fun getViewModelClass(): Class<ProfileViewModel> =
        ProfileViewModel::class.java

    override fun renderView(model: ProfileScreenState) {

    }

}