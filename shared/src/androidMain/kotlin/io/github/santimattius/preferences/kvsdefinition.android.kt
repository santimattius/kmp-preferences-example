package io.github.santimattius.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

actual fun createKvs(definition: KvsDefinition): KeyValueStorage {
    val pref = if (definition.encrypted) {
        createEncryptedSharedPref(definition)
    } else {
        val context = definition.context.applicationContext
        context.getSharedPreferences(definition.name(), Context.MODE_PRIVATE)
    }
    return AndroidKeyValueStorage(pref)
}

private fun createEncryptedSharedPref(definition: KvsDefinition): SharedPreferences {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    return EncryptedSharedPreferences.create(
        definition.name(),
        masterKeyAlias,
        definition.context.applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}

actual class KvsDefinition(
    val context: Context,
    private val name: String? = "",
    val encrypted: Boolean,
) {

    fun name() = if (name.isNullOrEmpty()) getDefaultSharedPreferencesName() else name
    private fun getDefaultSharedPreferencesName(): String {
        return context.packageName + "_preferences"
    }

}