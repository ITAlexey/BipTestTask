package com.example.biptesttask.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.presentation.fragments.WizardPageFragment
import java.lang.IllegalArgumentException

class WizardSliderAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int =
        PAGE_NUMBER

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> createPageFragment(position)
            1 -> createPageFragment(position)
            2 -> createPageFragment(position)
            else -> throw IllegalArgumentException("The number of fragment pages should not increase than $PAGE_NUMBER")
        }

    private fun createPageFragment(argCode: Int): Fragment =
        WizardPageFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_WIZARD_PAGE, argCode)
            }
        }

    companion object {
        private const val PAGE_NUMBER = 3
        const val ARG_WIZARD_PAGE = "ARG_WIZARD_PAGE_NUMBER"
    }
}