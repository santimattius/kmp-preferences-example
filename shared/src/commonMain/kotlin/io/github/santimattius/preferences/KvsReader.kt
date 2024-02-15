package io.github.santimattius.preferences


interface KvsReader {

    interface KvsEditor {

        fun putString(key: String, value: String): KvsEditor

        fun putInt(key: String, value: Int): KvsEditor

        fun putLong(key: String, value: Long): KvsEditor

        fun putFloat(key: String, value: Float): KvsEditor

        fun putBoolean(key: String, value: Boolean): KvsEditor

        fun remove(key: String): KvsEditor

        fun clear(): KvsEditor

        fun apply()

    }


    val all: Map<String, Any>

    fun getString(key: String, defValue: String): String

    fun getInt(key: String, defValue: Int): Int

    fun getLong(key: String, defValue: Long): Long

    fun getFloat(key: String, defValue: Float): Float

    fun getBoolean(key: String, defValue: Boolean): Boolean

    fun edit(): KvsEditor

    operator fun contains(key: String): Boolean

}
