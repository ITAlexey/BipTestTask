package com.example.biptesttask.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.biptesttask.R
import com.example.biptesttask.presentation.fragments.WizardFragment
import java.lang.IllegalArgumentException

class WizardAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int =
        QUALITY_WIZARD_ITEMS

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> WizardFragment(R.layout.fragment_wizard).apply {
                arguments = Bundle().apply {
                    putInt(ARG_WIZARD_STATE, 0)
                }
            }
            1 -> WizardFragment(R.layout.fragment_wizard).apply {
                arguments = Bundle().apply {
                    putInt(ARG_WIZARD_STATE, 1)
                }
            }
            else -> throw IllegalArgumentException()
        }

    companion object {
        private const val QUALITY_WIZARD_ITEMS = 2
        const val ARG_WIZARD_STATE = "ARG_WIZARD_STATE"
    }
}