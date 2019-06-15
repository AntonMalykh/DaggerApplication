package io.malykh.anton.daggerapplication

import android.content.SharedPreferences
import androidx.core.content.edit
import io.malykh.anton.data.TextStorage

class PreferencesTextStorage(private val preferences: SharedPreferences) : TextStorage {

    private companion object{
        const val KEY_TEXT = "KEY_TEXT"
    }

    override fun restore(): String? {
        return preferences.getString(KEY_TEXT, null)
    }

    override fun store(text: String) {
        preferences.edit {
            putString(KEY_TEXT, text)
        }
    }
}
