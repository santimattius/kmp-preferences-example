package io.github.santimattius.preferences

import platform.Foundation.NSUserDefaults

internal class IOSKeyValueStorage(
    private val userDefaults: NSUserDefaults
) : KeyValueStorage {

    override val all: Map<String, Any>
        get() = userDefaults.dictionaryRepresentation()
            .filter { it.key != null && it.value != null }
            .map { it.key.toString() to it.value!! }.toMap()

    override fun getString(key: String, defValue: String): String {
        return userDefaults.stringForKey(key) ?: defValue
    }

    override fun getInt(key: String, defValue: Int): Int {
        return userDefaults.integerForKey(key).toInt() ?: defValue
    }

    override fun getLong(key: String, defValue: Long): Long {
        return userDefaults.integerForKey(key) ?: defValue
    }

    override fun getFloat(key: String, defValue: Float): Float {
        return userDefaults.floatForKey(key) ?: defValue
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return userDefaults.boolForKey(key) ?: defValue
    }

    override fun edit(): KeyValueStorage.KvsEditor {
        return IOSKvsEditor(userDefaults)
    }

    override fun contains(key: String): Boolean {
        return userDefaults.dictionaryRepresentation().containsKey(key)
    }

}