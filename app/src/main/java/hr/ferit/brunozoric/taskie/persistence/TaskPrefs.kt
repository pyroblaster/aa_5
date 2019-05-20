package hr.ferit.brunozoric.taskie.persistence

import android.preference.PreferenceManager
import hr.ferit.brunozoric.taskie.Taskie


object TaskPrefs{
    private fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(Taskie.getContext())

    fun store(key: String, value: String){
        sharedPrefs().edit().putString(key,value).apply()
    }

    fun getString(key: String, defaultValue: String): String? {
        return sharedPrefs().getString(key, defaultValue)
    }
}