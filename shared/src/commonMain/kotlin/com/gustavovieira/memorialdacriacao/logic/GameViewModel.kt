package com.gustavovieira.memorialdacriacao.logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import com.gustavovieira.memorialdacriacao.data.CardType
import com.gustavovieira.memorialdacriacao.data.GameData
import com.gustavovieira.memorialdacriacao.data.MemoryCard

class GameViewModel {
    val cards = mutableStateListOf<MemoryCard>()
    private var firstSelectedCardIndex: Int? = null
    private var mismatchPairIndices: Pair<Int, Int>? = null

    init {
        generateDeck()
    }

    fun generateDeck() {
        cards.clear()
        val deck = mutableListOf<MemoryCard>()

        GameData.creationPairs.forEachIndexed { index, pair ->
            deck.add(
                MemoryCard(
                    id = index * 2,
                    pairId = index,
                    type = CardType.CONCEITO,
                    title = pair.conceptTitle,
                    body = pair.conceptBody
                )
            )
            deck.add(
                MemoryCard(
                    id = index * 2 + 1,
                    pairId = index,
                    type = CardType.BIBLICA,
                    title = pair.bibleTitle,
                    body = pair.bibleBody
                )
            )
        }

        deck.shuffle()
        cards.addAll(deck)
        firstSelectedCardIndex = null
        mismatchPairIndices = null
    }

    fun selectCard(position: Int): Boolean {
        checkAndClearMismatch()

        val card = cards[position]
        if (card.isMatched) return false
        if (card.isFaceUp) return false

        if (firstSelectedCardIndex == null) {
            firstSelectedCardIndex = position
            cards[position] = card.copy(isFaceUp = true)
            return true
        } else {
            val firstIndex = firstSelectedCardIndex!!
            if (firstIndex == position) return false

            cards[position] = card.copy(isFaceUp = true)
            firstSelectedCardIndex = null

            if (cards[firstIndex].pairId == cards[position].pairId) {
                cards[firstIndex] = cards[firstIndex].copy(isMatched = true)
                cards[position] = cards[position].copy(isMatched = true)
            } else {
                mismatchPairIndices = Pair(firstIndex, position)
            }
            return true
        }
    }

    fun checkAndClearMismatch() {
        mismatchPairIndices?.let { (first, second) ->
            cards[first] = cards[first].copy(isFaceUp = false)
            cards[second] = cards[second].copy(isFaceUp = false)
            mismatchPairIndices = null
        }
    }
}