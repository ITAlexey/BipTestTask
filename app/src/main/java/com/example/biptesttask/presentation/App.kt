package com.example.biptesttask.presentation

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.biptesttask.data.repository.SharedPrefsEncrypted
import com.example.biptesttask.presentation.viewmodels.factory.ViewModelFactory

class App : Application() {
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
//        val sharedPrefs = SharedPrefsEncrypted(this, SHARED_PREF_FILE)
        viewModelFactory = ViewModelFactory()
    }

    companion object {
        const val SHARED_PREF_FILE = "SHARED_PREF_FILE"
    }
}