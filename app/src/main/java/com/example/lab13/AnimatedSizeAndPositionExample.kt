package com.example.lab13

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedSizeAndPositionExample() {
    // Paso 1: Definir estados para el tamaño y la posición
    var isExpanded by remember { mutableStateOf(false) }

    // Animación de tamaño
    val boxSize by animateDpAsState(
        targetValue = if (isExpanded) 150.dp else 50.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación de posición
    val offsetX by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )
    val offsetY by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Paso 2: Estructura y disposición
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isExpanded = !isExpanded }) {
            Text(text = "Mover y Cambiar Tamaño")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cuadro animado
        Box(
            modifier = Modifier
                .size(boxSize)
                .offset(x = offsetX, y = offsetY)
                .background(Color.Blue)
        )
    }
}
