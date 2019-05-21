package hr.ferit.brunozoric.taskie.persistence

import android.preference.PreferenceManager
import hr.ferit.brunozoric.taskie.Taskie
import hr.ferit.brunozoric.taskie.ui.activities.MainActivity


object TaskPrefs{
    private fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(Taskie.getAppContext())

    fun store(key: String, value: String){
        sharedPrefs().edit().putString(key,value).apply()
    }

    fun getString(key: String, defaultValue: String): String? {
        return sharedPrefs().getString(key, defaultValue)
    }
}