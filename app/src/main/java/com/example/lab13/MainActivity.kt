package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.AnimatedColorExample
import com.example.lab13.ui.theme.AnimatedVisibilityExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var showVisibilityExample by remember { mutableStateOf(false) }
    var showColorExample by remember { mutableStateOf(false) }
    var showSizeAndPositionExample by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Ejercicios de Animación con Jetpack Compose")

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para Ejercicio 1: Animación de Visibilidad
        Button(onClick = {
            showVisibilityExample = true
            showColorExample = false
            showSizeAndPositionExample = false
        }) {
            Text("Ejercicio 1: Animación de Visibilidad")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para Ejercicio 2: Cambio de Color
        Button(onClick = {
            showColorExample = true
            showVisibilityExample = false
            showSizeAndPositionExample = false
        }) {
            Text("Ejercicio 2: Cambio de Color")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para Ejercicio 3: Animación de Tamaño y Posición
        Button(onClick = {
            showSizeAndPositionExample = true
            showVisibilityExample = false
            showColorExample = false
        }) {
            Text("Ejercicio 3: Tamaño y Posición")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el ejercicio correspondiente según la selección
        if (showVisibilityExample) {
            AnimatedVisibilityExample()
        }

        if (showColorExample) {
            AnimatedColorExample()
        }

        if (showSizeAndPositionExample) {
            AnimatedSizeAndPositionExample()
        }
    }
}
