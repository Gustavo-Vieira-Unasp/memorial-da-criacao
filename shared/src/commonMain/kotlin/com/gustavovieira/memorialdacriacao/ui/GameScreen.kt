package com.gustavovieira.memorialdacriacao

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.jetbrains.compose.resources.painterResource
import memorial_da_criacao.shared.generated.resources.Res
import memorial_da_criacao.shared.generated.resources.logo
import com.gustavovieira.memorialdacriacao.data.CardType
import com.gustavovieira.memorialdacriacao.data.MemoryCard
import com.gustavovieira.memorialdacriacao.logic.GameViewModel

@Composable
fun GameScreen() {
    val viewModel = remember { GameViewModel() }
    var activePopupCard by remember { mutableStateOf<MemoryCard?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E272E))
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items = viewModel.cards) { index, card ->
                MemoryCardView(
                    card = card,
                    onClick = {
                        val didFlipUp = viewModel.selectCard(index)

                        if (didFlipUp) {
                            activePopupCard = viewModel.cards[index]
                        } else if (viewModel.cards[index].isFaceUp || viewModel.cards[index].isMatched) {
                            activePopupCard = viewModel.cards[index]
                        }
                    }
                )
            }
        }

        activePopupCard?.let { card ->
            val isConcept = card.type == CardType.CONCEITO
            val accentColor = if (isConcept) Color(0xFFD4AF37) else Color(0xFF8B5A2B)
            val dialogBgColor = if (isConcept) Color(0xFFFFFDF0) else Color(0xFFFDFBF7)

            Dialog(
                onDismissRequest = {
                    activePopupCard = null
                    viewModel.checkAndClearMismatch()
                },
                properties = DialogProperties(usePlatformDefaultWidth = false)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .wrapContentHeight()
                        .padding(16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = dialogBgColor),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = if (isConcept) "💡 ${card.title}" else "📖 ${card.title}",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = accentColor,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 24.dp)
                            )

                            if (card.body.isNotBlank()) {
                                Text(
                                    text = card.body,
                                    fontSize = 16.sp,
                                    color = Color(0xFF2C3E50),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 22.sp,
                                    modifier = Modifier
                                        .heightIn(max = 160.dp)
                                        .verticalScroll(rememberScrollState())
                                )
                            } else {
                                Text(
                                    text = "Encontre o par correspondente deste conceito.",
                                    fontSize = 14.sp,
                                    color = Color.Gray,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(vertical = 8.dp)
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 12.dp, end = 12.dp)
                            .size(28.dp)
                            .background(accentColor.copy(alpha = 0.15f), CircleShape)
                            .clickable {
                                activePopupCard = null
                                viewModel.checkAndClearMismatch()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "✕",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MemoryCardView(card: MemoryCard, onClick: () -> Unit) {
    val isConcept = card.type == CardType.CONCEITO

    val goldGradient = Brush.linearGradient(
        colors = listOf(Color(0xFFB38728), Color(0xFFFBF5B7), Color(0xFFDAA520), Color(0xFFAA771C))
    )
    val parchmentGradient = Brush.linearGradient(
        colors = listOf(Color(0xFFF2E6CE), Color(0xFFE6D5B3), Color(0xFFD4BF94))
    )

    val cardTextColors = if (isConcept) Color(0xFF3E2723) else Color(0xFF2D1F10)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (card.isFaceUp || card.isMatched) Color.Transparent else Color(0xFF111111)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (card.isFaceUp || card.isMatched) {
                        Modifier.background(if (isConcept) goldGradient else parchmentGradient)
                    } else {
                        Modifier
                    }
                )
                .clickable { onClick() }
                .padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            if (card.isFaceUp || card.isMatched) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = if (isConcept) "💡" else "📖",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = card.title,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = cardTextColors,
                        textAlign = TextAlign.Center,
                        lineHeight = 13.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            } else {
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "Game Logo",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
        }
    }
}