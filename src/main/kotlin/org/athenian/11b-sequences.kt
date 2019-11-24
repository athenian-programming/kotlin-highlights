package org.athenian

fun main() {

  fun evenNumbers(max: Int): Sequence<Int> =
    sequence {
      repeat(max) { i ->
        if (i % 2 == 0)
          yield(i)
      }
    }

  for (v in evenNumbers(10))
    println("Val $v")


  val vals: List<Int> = evenNumbers(10).toList()
  println("Even numbers <= 10: ${vals}")


  fun evenNumbers2(max: Int): Sequence<Int> =
    sequence {
      (0..max)
        .filter { it % 2 == 0 }
        .forEach { yield(it) }
    }

  println("Even numbers <= 20: ${evenNumbers2(10).toList()}")

  fun oddNumbers(max: Int): Sequence<Int> =
    sequence {
      evenNumbers(max - 1)
        .forEach {
          yield(it + 1)
        }
    }


  val reversedOdds: String =
    oddNumbers(11)
      .toList()
      .reversed()
      .joinToString(", ")
  println("Odd numbers <= 11 reversed: $reversedOdds")

  val zipped: String =
    evenNumbers(6)
      .map { it * it }
      .zip(evenNumbers(6).map { it * it * it })
      .joinToString(", ")

  println("Zipped squares and cubes: $zipped")
}