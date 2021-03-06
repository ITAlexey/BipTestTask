package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.databinding.FragmentSliderBinding
import com.example.biptesttask.presentation.adapters.WalkthroughSliderAdapter
import com.example.biptesttask.presentation.adapters.WizardSliderAdapter
import com.example.biptesttask.presentation.command.SliderCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.models.WizardPageState
import com.example.biptesttask.presentation.viewmodels.SliderViewModel

class SliderFragment :
    BaseFragment<SliderScreenState, SliderCommand, SliderViewModel>() {
    private var adapter: FragmentStateAdapter? = null
    private lateinit var binding: FragmentSliderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSliderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()

        initListeners()
    }

    private fun initListeners() =
        with(binding) {
            btnFines.setOnClickListener { viewModel.onFinesButtonClicked() }
            imgBtnNext.setOnClickListener { viewModel.onArrowButtonClicked() }
        }

    override fun executeCommand(command: SliderCommand) =
        when (command) {
            is SliderCommand.AdapterType.Wizard ->
                setUpAdapter(WizardSliderAdapter(this))
            is SliderCommand.AdapterType.Walkthrough ->
                setUpAdapter(WalkthroughSliderAdapter(this))
            SliderCommand.Navigation.ToNextPage -> Unit
            SliderCommand.Navigation.ToProfile -> Unit
        }

    private fun setUpAdapter(createdAdapter: FragmentStateAdapter) {
        adapter = createdAdapter
        binding.viewPager.adapter = adapter
    }

    override fun getViewModelClass(): Class<SliderViewModel> =
        SliderViewModel::class.java

    override fun renderView(model: SliderScreenState) {
        updateBottomViewVisibility(model)
        updateButtonsVisibility(model)
        updateDotsVisibility(model)
    }

    private fun updateBottomViewVisibility(model: SliderScreenState) {
        binding.vBottomBackground.isVisible = model.isBottomViewVisible
    }

    private fun updateButtonsVisibility(model: SliderScreenState) {
        binding.btnFines.isVisible = model.isFinesButtonVisible
        binding.imgBtnNext.isVisible = model.isNextButtonVisible
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SLIDER", "onDestroy: viewPager2")
    }

    private fun updateDotsVisibility(model: SliderScreenState) {
        binding.rvDots.isVisible = model.isDotsVisible
    }

    fun moveToNextPage(pageState: WizardPageState) {
        binding.viewPager.currentItem = pageState.ordinal + 1
    }

    fun moveToPreviousPage(pageState: WizardPageState) {
        if (pageState.ordinal != 0) {
            binding.viewPager.currentItem = pageState.ordinal - 1
        }
    }
}