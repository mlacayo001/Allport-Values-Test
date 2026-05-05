package com.ml.allportvaluestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                PantallaTest()
            }
        }
    }
}

@Composable
fun PantallaTest(vm: AllportViewModel = viewModel()) {
    // Obtenemos la pregunta actual basada en el índice del ViewModel
    val pregunta = AllportRepository.preguntasParte1[vm.indicePregunta]

    // Puntos locales para la pregunta actual
    var pA by remember(vm.indicePregunta) { mutableIntStateOf(0) }
    var pB by remember(vm.indicePregunta) { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Test de Allport - UAM", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))

        // Tarjeta con estética translúcida (Glassmorphism)
        Card(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF00E5FF).copy(alpha = 0.1f)),
            border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = pregunta.enunciado, fontSize = 18.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text("Reparta 3 puntos entre las opciones:")

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { if (pA < 3) { pA++; pB = 3 - pA } }) { Text("A: $pA") }
            Button(onClick = { if (pB < 3) { pB++; pA = 3 - pB } }) { Text("B: $pB") }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                // Guardar respuestas en el ViewModel
                vm.registrarRespuesta(pregunta.columnaA, pA)
                vm.registrarRespuesta(pregunta.columnaB, pB)

                // Avanzar a la siguiente pregunta
                vm.avanzarSiguiente()
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            enabled = (pA + pB == 3) // Solo se activa si repartió los 3 puntos
        ) {
            Text(if (vm.indicePregunta < AllportRepository.preguntasParte1.size - 1) "Siguiente" else "Finalizar Parte 1")
        }
    }
}