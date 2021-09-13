package com.example.biptesttask.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.presentation.fragments.WalkthroughPageFragment
import java.lang.IllegalArgumentException

class WalkthroughSliderAdapter(
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
            3 -> createPageFragment(position)
            else -> throw IllegalArgumentException()
        }

    private fun createPageFragment(argCode: Int): Fragment =
        WalkthroughPageFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_WALKTHROUGH_PAGE, argCode)
            }
        }


    companion object {
        private const val PAGE_NUMBER = 4
        const val ARG_WALKTHROUGH_PAGE = "ARG_WALKTHROUGH_PAGE"
    }
}