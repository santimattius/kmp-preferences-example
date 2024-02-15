package io.github.santimattius.preferences

import platform.Foundation.NSUserDefaults

actual fun createKvs(definition: KvsDefinition): KeyValueStorage {
    val userDefaults = if (definition.name.isNullOrEmpty()) {
        NSUserDefaults.standardUserDefaults()
    } else {
        NSUserDefaults(suiteName = definition.name)
    }
    return IOSKeyValueStorage( userDefaults)
}

actual class KvsDefinition(
    val name: String? = "",
)