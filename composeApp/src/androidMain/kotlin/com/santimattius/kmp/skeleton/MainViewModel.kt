package com.santimattius.kmp.skeleton

import Greeting
import androidx.lifecycle.ViewModel
import io.github.santimattius.preferences.Kvs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val kvs: Kvs
) : ViewModel() {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    fun onTap() {
        val isOnTapped = kvs.getBoolean(KEY_SHOW_TEXT, false)
        kvs.edit().putBoolean(KEY_SHOW_TEXT, !isOnTapped).apply()
        _state.update {
            it.copy(
                showText = kvs.getBoolean(KEY_SHOW_TEXT, false),
                text = "Compose: ${Greeting().greet()}"
            )
        }
    }

    companion object {
        private const val KEY_SHOW_TEXT = "show_text"
    }
}