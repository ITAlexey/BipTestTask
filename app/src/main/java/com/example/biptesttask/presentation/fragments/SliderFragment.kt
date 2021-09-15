package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.databinding.FragmentSliderBinding
import com.example.biptesttask.presentation.adapters.WizardSliderAdapter
import com.example.biptesttask.presentation.command.WizardSliderCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.SliderViewModel

class SliderFragment :
    BaseFragment<SliderScreenState, WizardSliderCommand, SliderViewModel>() {
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

        setUpAdapter()
    }

    private fun setUpAdapter() {
        adapter = WizardSliderAdapter(parentFragmentManager, lifecycle)
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

    private fun updateDotsVisibility(model: SliderScreenState) {
        binding.rvDots.isVisible = model.isDotsVisible
    }
}