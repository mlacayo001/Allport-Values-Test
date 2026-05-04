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
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                PantallaTest()
            }
        }
    }
}

@Composable
fun PantallaTest(allportViewModel: AllportViewModel = viewModel()) {
    // Tomamos la primera pregunta del repositorio
    val pregunta = AllportRepository.preguntasParte1[0]

    // Usamos mutableIntStateOf para mejor rendimiento como sugirió tu IDE
    var puntosA by remember { mutableIntStateOf(0) }
    var puntosB by remember { mutableStateOf(0) } // Este se actualiza en base a A

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Test de Valores de Allport", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))

        // TARJETA ESTILO GLASSMORPHISM
        Card(
            modifier = Modifier.fillMaxWidth().height(250.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF00E5FF).copy(alpha = 0.1f)),
            border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Pregunta ${pregunta.id}", fontWeight = FontWeight.Bold, color = Color.Gray)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = pregunta.enunciado, fontSize = 18.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text("Reparta 3 puntos entre las opciones:", fontWeight = FontWeight.Medium)

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botón Opción A
            OutlinedButton(
                onClick = { if (puntosA < 3) { puntosA++; puntosB = 3 - puntosA } },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color(0xFF00E5FF))
            ) {
                Text("A: $puntosA", color = Color.Black)
            }

            // Botón Opción B
            OutlinedButton(
                onClick = { if (puntosB < 3) { puntosB++; puntosA = 3 - puntosB } },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color(0xFF00E5FF))
            ) {
                Text("B: $puntosB", color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                allportViewModel.registrarRespuesta(pregunta.columnaA, puntosA)
                allportViewModel.registrarRespuesta(pregunta.columnaB, puntosB)
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("Siguiente Pregunta", color = Color.White)
        }
    }
}