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
    val pregunta = AllportRepository.preguntasParte1[0]
    var pA by remember { mutableIntStateOf(0) }
    var pB by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Test de Allport", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF00E5FF).copy(alpha = 0.1f)),
            border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(pregunta.enunciado, fontSize = 18.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text("Reparta 3 puntos entre A y B")

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { if (pA < 3) { pA++; pB = 3 - pA } }) { Text("A: $pA") }
            Button(onClick = { if (pB < 3) { pB++; pA = 3 - pB } }) { Text("B: $pB") }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {
            vm.registrarRespuesta(pregunta.columnaA, pA)
            vm.registrarRespuesta(pregunta.columnaB, pB)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Siguiente")
        }
    }
}