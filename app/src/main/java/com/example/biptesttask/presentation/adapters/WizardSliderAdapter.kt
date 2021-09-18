package com.example.biptesttask.presentation.adapters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.presentation.fragments.WizardPageFragment
import java.lang.IllegalArgumentException

class WizardSliderAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
//    private val listFragments: List<WizardPageFragment> = listOf(
//        WizardPageFragment(),
//        WizardPageFragment(),
//        WizardPageFragment()
//    )

    override fun getItemCount(): Int =
        PAGE_NUMBER

    override fun createFragment(position: Int): Fragment =
        if (position in 0..2) {
            Log.d("SLIDER", "createFragment: $position")
            createPageFragment(position)
        } else {
            throw IllegalArgumentException("The number of fragment pages should not increase than $PAGE_NUMBER")
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