package com.ml.allportvaluestest

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AllportViewModel : ViewModel() {
    // Usamos los nombres sin tildes para evitar errores de compilación
    var resultadosBrutos = mutableStateOf(AllportModel())

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

    // Esta es la función del warning; ignóralo o úsala al final del test
    fun obtenerPuntajeFinal(): AllportModel {
        val finales = resultadosBrutos.value.copy()
        finales.teoretico += 3  // Cifra de corrección R
        finales.economico -= 1  // Cifra de corrección S
        finales.estetico += 4   // Cifra de corrección T
        finales.social -= 3     // Cifra de corrección X
        finales.politico += 2   // Cifra de corrección Y
        finales.religioso -= 5  // Cifra de corrección Z
        return finales
    }
}