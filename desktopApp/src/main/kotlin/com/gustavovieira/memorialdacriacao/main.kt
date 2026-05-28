package com.gustavovieira.memorialdacriacao

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "memorial-da-criacao",
    ) {
        App()
    }
}