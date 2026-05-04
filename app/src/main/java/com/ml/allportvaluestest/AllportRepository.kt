package com.ml.allportvaluestest
object AllportRepository {

    // --- PRIMERA PARTE (Páginas 2 a 5) ---
    // El usuario debe repartir 3 puntos entre A y B
    val preguntasParte1 = listOf(
        PreguntaParte1(
            id = 1,
            enunciado = "El principal objeto de la investigación científica es el descubrir la verdad y no darle una aplicación práctica.",
            opcionA = "Sí",
            opcionB = "No",
            columnaA = "R", // Teórico
            columnaB = "S"  // Económico
        ),
        PreguntaParte1(
            id = 2,
            enunciado = "La Biblia se debe mirar desde un punto de vista de su bella mitología y no como una revelación espiritual.",
            opcionA = "Sí",
            opcionB = "No",
            columnaA = "Z", // Religioso
            columnaB = "Y"  // Político
        ),
        PreguntaParte1(
            id = 3,
            enunciado = "¿A cuál de los siguientes hombres cree que debe atribuírsele más mérito como contribuidor al progreso de la humanidad?",
            opcionA = "Aristóteles",
            opcionB = "Simón Bolívar",
            columnaA = "X", // Social
            columnaB = "T"  // Estético
        ),
        PreguntaParte1(
            id = 4,
            enunciado = "Dando por hecho que usted tiene la habilidad necesaria, preferiría ser:",
            opcionA = "Banquero",
            opcionB = "Político",
            columnaA = "S", // Económico
            columnaB = "R"  // Teórico
        )
    )

    // --- SEGUNDA PARTE (Páginas 7 a 9) ---
    // El usuario debe ordenar las 4 opciones del 4 al 1
    val preguntasParte2 = listOf(
        PreguntaParte2(
            id = 1,
            enunciado = "Le parece a usted que un buen gobierno debe preocuparse más por:",
            opciones = listOf(
                "a. Dar más ayuda a los pobres, enfermos y ancianos",
                "b. Desarrollar la industria y el comercio",
                "c. Introducir los más elevados principios de la ética",
                "d. Colocar a la nación en una posición de prestigio"
            ),
            columnasAsociadas = listOf("X", "S", "R", "Y") // Social, Económico, Teórico, Político
        ),
        PreguntaParte2(
            id = 2,
            enunciado = "Si usted tuviera tiempo y dinero, ¿qué preferiría hacer?",
            opciones = listOf(
                "a. Ayudar a las personas que necesitan caridad",
                "b. Dedicarse al estudio de las bellas artes",
                "c. Invertir en negocios productivos",
                "d. Estudiar los misterios de la naturaleza"
            ),
            columnasAsociadas = listOf("X", "T", "S", "R") // Social, Estético, Económico, Teórico
        )
    )
}