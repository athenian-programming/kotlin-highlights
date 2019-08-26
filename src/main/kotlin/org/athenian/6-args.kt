package org.athenian

// Named arguments -- improves readability for long arg lists
// Default arguments

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
    // ...
}

fun func(i: Int = 5, j: Int = 6) = i * j

fun main() {
    println("Result of func(3, 4) = ${func(3, 4)}")
    println("Result of func(i = 7, j = 4) = ${func(i = 7, j = 4)}")
    println("Result of func(i = 7) = ${func(i = 7)}")
    println("Result of func() = ${func()}")
}
