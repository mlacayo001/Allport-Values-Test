package com.ml.allportvaluestest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AllportViewModel : ViewModel() {
    var resultadosBrutos = mutableStateOf(AllportModel())

    // Estado para controlar la navegación entre preguntas
    var indicePregunta by mutableIntStateOf(0)

    fun registrarRespuesta(columna: String, puntos: Int) {
        val copia = resultadosBrutos.value.copy()
        when (columna) {
            "R" -> copia.teoretico += puntos
            "S" -> copia.economico += puntos
            "T" -> copia.estetico += puntos
            "X" -> copia.social += puntos
            "Y" -> copia.politico += puntos
            "Z" -> copia.religioso += puntos
        }
        resultadosBrutos.value = copia
    }

    fun avanzarSiguiente() {
        if (indicePregunta < AllportRepository.preguntasParte1.size - 1) {
            indicePregunta++
        }
    }

    fun obtenerPuntajeFinal(): AllportModel {
        val finales = resultadosBrutos.value.copy()
        finales.teoretico += 3
        finales.economico -= 1
        finales.estetico += 4
        finales.social -= 3
        finales.politico += 2
        finales.religioso -= 5
        return finales
    }
}