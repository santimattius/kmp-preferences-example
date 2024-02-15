package io.github.santimattius.preferences

import platform.Foundation.NSUserDefaults

class IOSKvsEditor(
    private val userDefaults: NSUserDefaults
) : KvsReader.KvsEditor {
    override fun putString(key: String, value: String): KvsReader.KvsEditor {
        return apply {
            userDefaults.setObject(value, key)
        }
    }

    override fun putInt(key: String, value: Int): KvsReader.KvsEditor {
        return apply {
            userDefaults.setInteger(value.toLong(), key)
        }
    }

    override fun putLong(key: String, value: Long): KvsReader.KvsEditor {
        return apply {
            userDefaults.setInteger(value, key)
        }
    }

    override fun putFloat(key: String, value: Float): KvsReader.KvsEditor {
        return apply {
            userDefaults.setFloat(value, key)
        }
    }

    override fun putBoolean(key: String, value: Boolean): KvsReader.KvsEditor {
        return apply {
            userDefaults.setBool(value, key)
        }
    }

    override fun remove(key: String): KvsReader.KvsEditor {
        return apply {
            userDefaults.removeObjectForKey(key)
        }
    }

    override fun clear(): KvsReader.KvsEditor {
        return apply {
            userDefaults.dictionaryRepresentation().forEach {
                remove(it.key.toString())
            }
        }
    }

    override fun apply() {
        userDefaults.synchronize()
    }
}