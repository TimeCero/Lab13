package com.example.lab13.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
fun AnimatedVisibilityExample() {
    var isVisible by remember { mutableStateOf(false) } // Paso 3.1: Define el estado

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Paso 3.2: Botón para alternar la visibilidad
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Ocultar Cuadro" else "Mostrar Cuadro")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Paso 3.3: Cuadro de color con animación de visibilidad
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),      // Efecto de entrada (fade in)
            exit = fadeOut()        // Efecto de salida (fade out)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
        }
    }
}
