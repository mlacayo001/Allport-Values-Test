package com.ml.allportvaluestest

/**
 * Repositorio actualizado según la hoja de respuestas oficial.
 * Cada 'columnaA' y 'columnaB' corresponde al valor (R, S, T, X, Y, Z)
 * indicado en las casillas de calificación del manual.
 */
object AllportRepository {

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
            columnaA = "S", // Económico (Columna S en tu imagen)
            columnaB = "Y"  // Político
        ),
        PreguntaParte1(
            id = 5,
            enunciado = "¿Cree justificable que los grandes artistas como Beethoven, Wagner y Byron hayan sido egoístas e indiferentes a los sentimientos de otros?",
            opcionA = "Sí",
            opcionB = "No",
            columnaA = "T", // Estético (Columna T en tu imagen)
            columnaB = "X"  // Social
        ),
        PreguntaParte1(
            id = 6,
            enunciado = "¿Cuál de estas dos disciplinas cree que llegarán a tener en el futuro un mayor valor para la humanidad?",
            opcionA = "Las matemáticas",
            opcionB = "La teología",
            columnaA = "R", // Teórico (Columna R en tu imagen)
            columnaB = "Z"  // Religioso
        ),
        PreguntaParte1(
            id = 7,
            enunciado = "¿Cuál considera usted que debe ser la función más importante de los grandes dirigentes modernos?",
            opcionA = "Inducir a la gente a obtener resultados prácticos",
            opcionB = "Inducir a la gente a interesarse por los Derechos de otros",
            columnaA = "S", // Económico (Columna S en tu imagen)
            columnaB = "X"  // Social
        ),
        PreguntaParte1(
            id = 8,
            enunciado = "Cuando presencia una ceremonia pomposa (eclesiástica o académica) ¿qué le impresiona más?",
            opcionA = "El colorido y formalidad del acto mismo",
            opcionB = "La influencia y la fuerza del grupo",
            columnaA = "T", // Estético (Columna T en tu imagen)
            columnaB = "Y"  // Político
        )
    )

    // La Parte 2 se mantiene con su lógica de ordenamiento (4, 3, 2, 1)
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
            columnasAsociadas = listOf("X", "S", "R", "Y")
        )
    )
}