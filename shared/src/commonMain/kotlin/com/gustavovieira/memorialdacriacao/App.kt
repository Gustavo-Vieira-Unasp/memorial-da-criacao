package com.gustavovieira.memorialdacriacao

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

enum class ScreenState {
    START_MENU,
    GAME_PLAY
}

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(ScreenState.START_MENU) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1E272E)
    ) {
        when (currentScreen) {
            ScreenState.START_MENU -> {
                StartMenuScreen(onPlayClick = { currentScreen = ScreenState.GAME_PLAY })
            }
            ScreenState.GAME_PLAY -> {
                GameScreen()
            }
        }
    }
}