package com.gustavovieira.memorialdacriacao

data class MemoryCard(
    val id: Int,
    val pairId: Int,
    val text: String,
    val isFaceUp: Boolean = false,
    val isMatched: Boolean = false
)