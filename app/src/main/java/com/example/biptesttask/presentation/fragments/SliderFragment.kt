package com.example.biptesttask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.biptesttask.databinding.FragmentSliderBinding
import com.example.biptesttask.presentation.adapters.WalkthroughSliderAdapter
import com.example.biptesttask.presentation.adapters.WizardSliderAdapter
import com.example.biptesttask.presentation.command.WizardSliderCommand
import com.example.biptesttask.presentation.fragments.base.BaseFragment
import com.example.biptesttask.presentation.models.SliderScreenState
import com.example.biptesttask.presentation.viewmodels.SliderViewModel

class SliderFragment :
    BaseFragment<
            SliderScreenState,
            WizardSliderCommand,
            SliderViewModel>(
        SliderViewModel::class.java
    ) {
    private var adapter: FragmentStateAdapter? = null
    private val binding by viewBinding(FragmentSliderBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter(WIZARD_ADAPTER)
    }

    private fun setUpAdapter(adapterType: String) {
        adapter = if (adapterType == WIZARD_ADAPTER) {
            WizardSliderAdapter(parentFragmentManager, lifecycle)
        } else {
            WalkthroughSliderAdapter(parentFragmentManager, lifecycle)
        }
        binding.viewPager.adapter = adapter
    }

    fun moveToAccordingPage(currentPosition: Int) {
        binding.viewPager.currentItem = currentPosition
    }

    fun applyWalkthroughAdapter() =
        setUpAdapter(WALKTHROUGH_ADAPTER)

    override fun onDestroy() {
        super.onDestroy()

        adapter = null
    }

    companion object {
        private const val WIZARD_ADAPTER = "WIZARD"
        private const val WALKTHROUGH_ADAPTER = "WALKTHROUGH"
    }
}