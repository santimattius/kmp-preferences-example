package com.santimattius.kmp.skeleton

import io.github.santimattius.preferences.Kvs
import io.github.santimattius.preferences.KvsDefinition
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Kvs(
            definition = KvsDefinition(
                androidApplication(),
                name = "kvs_android",
                encrypted = false
            )
        )
    }
    viewModel {
        MainViewModel(get())
    }
}