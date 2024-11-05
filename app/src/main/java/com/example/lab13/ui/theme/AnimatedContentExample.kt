package com.example.lab13.ui.theme

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Paso 1: Definir los estados como un enum
enum class ContentState {
    Cargando,
    Contenido,
    Error
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExample() {
    // Variable de estado para el estado actual
    var currentState by remember { mutableStateOf(ContentState.Cargando) }

    // Paso 2: Estructura de la interfaz
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para cambiar de estado
        Button(onClick = {
            currentState = when (currentState) {
                ContentState.Cargando -> ContentState.Contenido
                ContentState.Contenido -> ContentState.Error
                ContentState.Error -> ContentState.Cargando
            }
        }) {
            Text("Cambiar Estado")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Animación de cambio de contenido
        AnimatedContent(
            targetState = currentState,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) with fadeOut(animationSpec = tween(500))
            }
        ) { state ->
            when (state) {
                ContentState.Cargando -> Text("Cargando...")
                ContentState.Contenido -> Text("Contenido cargado")
                ContentState.Error -> Text("Error al cargar contenido")
            }
        }
    }
}
