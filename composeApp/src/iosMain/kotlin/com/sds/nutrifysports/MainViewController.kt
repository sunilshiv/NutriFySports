package com.sds.nutrifysports

import androidx.compose.ui.window.ComposeUIViewController
import com.nutrifysports.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin () }
) { App() }