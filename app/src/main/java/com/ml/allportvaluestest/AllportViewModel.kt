package com.ml.allportvaluestest

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AllportViewModel : ViewModel() {
    // Estado que guarda los resultados brutos
    var resultadosBrutos = mutableStateOf(AllportModel())

    // Función para sumar puntos a las columnas R, S, T, X, Y, Z
    fun registrarRespuesta(columna: String, puntos: Int) {
        val copia = resultadosBrutos.value.copy()
        when (columna) {
            "R" -> copia.teorético += puntos[cite: 1]
            "S" -> copia.económico += puntos[cite: 1]
            "T" -> copia.estético += puntos[cite: 1]
            "X" -> copia.social += puntos[cite: 1]
            "Y" -> copia.político += puntos[cite: 1]
            "Z" -> copia.religioso += puntos[cite: 1]
        }
        resultadosBrutos.value = copia
    }

    // Aplica las cifras de corrección obligatorias de la página 10 del PDF
    fun obtenerPuntajeFinal(): AllportModel {
        val finales = resultadosBrutos.value.copy()
        finales.teorético += 3  // Corrección Teórica
        finales.económico -= 1  // Corrección Económica
        finales.estético += 4   // Corrección Estética[cite: 1]
        finales.social -= 3     // Corrección Social[cite: 1]
        finales.político += 2   // Corrección Política[cite: 1]
        finales.religioso -= 5  // Corrección Religiosa[cite: 1]
        return finales
    }
}