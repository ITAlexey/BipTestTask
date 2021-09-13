package com.example.biptesttask.data.repository

import android.app.Application
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class SharedPrefsEncrypted(application: Application, prefsName: String) {
    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
    private val sharedPrefs = EncryptedSharedPreferences.create(
        prefsName,
        mainKeyAlias,
        application,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveData(key: String, data: String) =
        sharedPrefs
            .edit()
            .putString(key, data)
            .apply()

    fun getData(key: String, defaultValue: String) =
        sharedPrefs.getString(key, defaultValue) ?: EMPTY_LINE

    fun removeData(key: String) =
        sharedPrefs
            .edit()
            .remove(key)
            .apply()

    companion object {
        private const val EMPTY_LINE = ""
    }
}