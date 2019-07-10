package org.athenian

// Default arguments
fun func(i: Int = 5, j: Int = 6) = i * j

// Improves readability for long arg lists
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
    // ...
}

fun main() {

    // Named arguments
    println("Result of func(3, 4) = ${func(3, 4)}")
    println("Result of func(i = 7, j = 4) = ${func(i = 7, j = 4)}")
    println("Result of func(i = 7) = ${func(i = 7)}")
    println("Result of func() = ${func()}")
}