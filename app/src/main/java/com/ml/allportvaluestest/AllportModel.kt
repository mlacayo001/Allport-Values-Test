package com.ml.allportvaluestest
data class AllportModel(
    var teorético: Int = 0,  // Corresponde a la columna R en el PDF
    var económico: Int = 0,  // Corresponde a la columna S en el PDF
    var estético: Int = 0,   // Corresponde a la columna T en el PDF
    var social: Int = 0,     // Corresponde a la columna X en el PDF[cite: 1]
    var político: Int = 0,   // Corresponde a la columna Y en el PDF[cite: 1]
    var religioso: Int = 0   // Corresponde a la columna Z en el PDF[cite: 1]
)

/**
 * Representa una pregunta individual de la Primera Parte del test.
 * Donde el usuario debe distribuir un total de 3 puntos[cite: 1].
 */
data class PreguntaParte1(
    val id: Int,
    val enunciado: String,
    val opcionA: String,
    val opcionB: String,
    val columnaA: String, // Indica a qué columna (R, S, T, etc.) suma la opción A[cite: 1]
    val columnaB: String  // Indica a qué columna (R, S, T, etc.) suma la opción B[cite: 1]
)

/**
 * Representa una pregunta de la Segunda Parte.
 * Donde el usuario ordena 4 opciones del 1 al 4[cite: 1].
 */
data class PreguntaParte2(
    val id: Int,
    val enunciado: String,
    val opciones: List<String>,
    val columnasAsociadas: List<String> // Mapeo de cada opción a su columna correspondiente[cite: 1]
)