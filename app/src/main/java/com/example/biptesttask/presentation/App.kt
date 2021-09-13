package com.example.biptesttask.presentation

import android.app.Application
import com.example.biptesttask.data.repository.SharedPrefsEncrypted

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        val sharedPrefs = SharedPrefsEncrypted(this, SHARED_PREF_FILE)
    }

    companion object {
        const val SHARED_PREF_FILE = "SHARED_PREF_FILE"
    }
}