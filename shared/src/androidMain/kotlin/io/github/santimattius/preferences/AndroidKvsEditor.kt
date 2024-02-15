package io.github.santimattius.preferences

import android.content.SharedPreferences

class AndroidKvsEditor(
    private val sharedPreferences: SharedPreferences,
) : KvsReader.KvsEditor {

    private val editor = sharedPreferences.edit()

    override fun putString(key: String, value: String): KvsReader.KvsEditor {
        return apply {
            editor.putString(key, value)
        }
    }

    override fun putInt(key: String, value: Int): KvsReader.KvsEditor {
        return apply {
            editor.putInt(key, value)
        }
    }

    override fun putLong(key: String, value: Long): KvsReader.KvsEditor {
        return apply {
            editor.putLong(key, value)
        }
    }

    override fun putFloat(key: String, value: Float): KvsReader.KvsEditor {
        return apply {
            editor.putFloat(key, value)
        }
    }

    override fun putBoolean(key: String, value: Boolean): KvsReader.KvsEditor {
        return apply {
            editor.putBoolean(key, value)
        }
    }

    override fun remove(key: String): KvsReader.KvsEditor {
        return apply {
            editor.remove(key)
        }
    }

    override fun clear(): KvsReader.KvsEditor {
        return apply {
            editor.clear()
        }
    }

    override fun apply() {
        editor.apply()
    }
}