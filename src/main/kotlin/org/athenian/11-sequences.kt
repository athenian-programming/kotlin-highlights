package org.athenian

fun main() {

    fun doReMi(): Sequence<String> =
        sequence {
            listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do").forEach { yield(it) }
        }

    fun evenNumbers(max: Int) =
        sequence {
            repeat(max) { i ->
                if (i % 2 == 0)
                    yield(i)
            }
            // or
            /*
            (0..max)
                .filter{it % 2 == 0}
                .forEach { yield(it) }
            */
        }

    fun oddNumbers(max: Int): Sequence<Int> =
        sequence {
            evenNumbers(max - 1).forEach { yield(it + 1) }
        }

    for (note in doReMi())
        println(note)

    print("Even numbers <= 10: ")
    evenNumbers(10).forEach { print("$it ") }
    println()

    val everyOther =
        doReMi()
            .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
            .filter { it.isNotEmpty() }
            .toList()
    println("Every other note: $everyOther")

    val reversedOdds = oddNumbers(11).toList().reversed().joinToString(", ")
    println("Odd numbers <= 11 reversed: $reversedOdds")

    val zipped = evenNumbers(6).map { it * it }.zip(evenNumbers(6).map { it * it * it }).joinToString(", ")
    println("Zipped squares and cubes: $zipped")
}