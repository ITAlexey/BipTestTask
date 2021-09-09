package com.example.biptesttask.presentation.fragments

import androidx.annotation.LayoutRes
import com.example.biptesttask.presentation.models.ProfileScreenState
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.viewmodels.ProfileViewModel

class ProfileFragment(@LayoutRes layoutResId: Int) : BaseFragment<
        ProfileScreenState,
        ProfileViewModel>(
    layoutResId,
    ProfileViewModel::class.java
) {

    override fun renderView(model: ProfileScreenState) {
        TODO("Not yet implemented")
    }

}