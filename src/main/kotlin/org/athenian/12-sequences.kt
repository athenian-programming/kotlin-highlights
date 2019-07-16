package org.athenian

fun doReMi(): Sequence<String> {
    val notes = listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
    return sequence {
        for (note in notes)
            yield(note)
    }
}


fun evenNumbers(max: Int) =
    sequence {
        for (i in 0..max)
            if (i % 2 == 0)
                yield(i)
    }

fun oddNumbers(max: Int): Sequence<Int> {
    val evens = evenNumbers(max - 1)
    return sequence {
        evens.forEach { yield(it + 1) }
    }
}

fun main() {
    for (note in doReMi())
        println(note)

    print("Even numbers <= 10: ")
    evenNumbers(10).forEach { print("$it ") }
    println()

    val everyOther =
        doReMi()
            .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
            .filter { it.length > 0 }
            .toList()
    println("Every other note: $everyOther")

    val reversedOdds = oddNumbers(11).toList().reversed().joinToString(", ")
    println("Odd numbers <= 11 reversed: $reversedOdds")

    val zipped = evenNumbers(6).map { it * it }.zip(evenNumbers(6).map { it * it * it }).joinToString(", ")
    println("Zipped squares and cubes: $zipped")
}