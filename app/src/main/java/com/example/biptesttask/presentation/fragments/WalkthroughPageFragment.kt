package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.biptesttask.databinding.FragmentItemWalkthroughPageBinding
import com.example.biptesttask.presentation.command.WalkthroughPageCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.WalkthroughPageScreenState
import com.example.biptesttask.presentation.viewmodels.WalkthroughPageViewModel

class WalkthroughPageFragment :
    BaseFragment<
            WalkthroughPageScreenState,
            WalkthroughPageCommand,
            WalkthroughPageViewModel>(
        WalkthroughPageViewModel::class.java
    ) {
    private val binding by viewBinding(FragmentItemWalkthroughPageBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        binding.root
}