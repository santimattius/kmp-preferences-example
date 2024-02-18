package io.github.santimattius.preferences

import android.content.SharedPreferences

internal class AndroidKeyValueStorage(
    private val sharedPreferences: SharedPreferences,
) : KeyValueStorage {

    override val all: Map<String, Any>
        get() = sharedPreferences.all.map { it.key to it.value }.toMap()
            .filter { it.value != null } as Map<String, Any>

    override fun getString(key: String, defValue: String): String {
        return sharedPreferences.getString(key, defValue) ?: defValue
    }

    override fun getInt(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    override fun getLong(key: String, defValue: Long): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    override fun getFloat(key: String, defValue: Float): Float {
        return sharedPreferences.getFloat(key, defValue)
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    override fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }


    override fun edit(): KeyValueStorage.KvsEditor {
        return AndroidKvsEditor(sharedPreferences)
    }

}