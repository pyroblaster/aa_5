package hr.ferit.brunozoric.taskie.persistence

import android.preference.PreferenceManager
import hr.ferit.brunozoric.taskie.Taskie


object TaskPrefs{
    private fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(Taskie.getAppContext())

    fun storeInt(key: String, value: Int){
        sharedPrefs().edit().putInt(key,value).apply()
    }

    fun getInt(key: String, value:Int): Int {
        return sharedPrefs().getInt(key, 0)
    }
}