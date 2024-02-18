package com.santimattius.kmp.skeleton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    viewModel: MainViewModel = koinViewModel()
) {
    MaterialTheme {
        val state by viewModel.state.collectAsState()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = viewModel::onTap) {
                Text(state.text)
            }
            AnimatedVisibility(state.showText) {
                Image(
                    painter = painterResource("compose-multiplatform.xml"),
                    contentDescription = null
                )
            }
        }
    }
}