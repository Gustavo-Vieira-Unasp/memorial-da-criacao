package com.gustavovieira.memorialdacriacao

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import memorial_da_criacao.shared.generated.resources.Res
import memorial_da_criacao.shared.generated.resources.logo

@Composable
fun StartMenuScreen(onPlayClick: () -> Unit) {
    val goldGradient = Brush.linearGradient(
        colors = listOf(Color(0xFFB38728), Color(0xFFFBF5B7), Color(0xFFDAA520), Color(0xFFAA771C))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E272E)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Memorial da Criação Logo",
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .heightIn(max = 240.dp)
            )

            Button(
                onClick = onPlayClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .width(200.dp)
                    .height(56.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(goldGradient),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "JOGAR",
                        color = Color(0xFF3E2723),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                }
            }
        }
    }
}