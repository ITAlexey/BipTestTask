package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biptesttask.databinding.FragmentItemWalkthroughPageBinding
import com.example.biptesttask.presentation.command.WalkthroughPageCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.WalkthroughPageScreenState
import com.example.biptesttask.presentation.viewmodels.WalkthroughPageViewModel

class WalkthroughPageFragment :
    BaseFragment<WalkthroughPageScreenState, WalkthroughPageCommand, WalkthroughPageViewModel>() {
    private lateinit var binding: FragmentItemWalkthroughPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemWalkthroughPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getViewModelClass(): Class<WalkthroughPageViewModel> =
        WalkthroughPageViewModel::class.java

    override fun renderView(model: WalkthroughPageScreenState) {
    }
}