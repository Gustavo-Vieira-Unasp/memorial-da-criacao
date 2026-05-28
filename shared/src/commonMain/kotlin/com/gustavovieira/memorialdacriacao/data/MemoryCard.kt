package com.gustavovieira.memorialdacriacao.data

enum class CardType {
    CONCEITO, BIBLICA
}

data class MemoryCard(
    val id: Int,
    val pairId: Int,
    val type: CardType,
    val title: String,
    val body: String,
    val isFaceUp: Boolean = false,
    val isMatched: Boolean = false
)