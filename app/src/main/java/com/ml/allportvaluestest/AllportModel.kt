package com.ml.allportvaluestest

// He quitado las tildes para evitar los errores de Non-ASCII que muestra tu pantalla
data class AllportModel(
    var teoretico: Int = 0,  // Antes: teorético
    var economico: Int = 0,  // Antes: económico
    var estetico: Int = 0,   // Antes: estético
    var social: Int = 0,     // Sin tilde ya estaba bien
    var politico: Int = 0,   // Antes: político
    var religioso: Int = 0   // Sin tilde ya estaba bien
)

data class PreguntaParte1(
    val id: Int,
    val enunciado: String,
    val opcionA: String,
    val opcionB: String,
    val columnaA: String,
    val columnaB: String
)

data class PreguntaParte2(
    val id: Int,
    val enunciado: String,
    val opciones: List<String>,
    val columnasAsociadas: List<String>
)