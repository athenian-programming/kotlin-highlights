package org.athenian

fun main() {

  fun evenNumbers(max: Int): Sequence<Int> =
    sequence {
      repeat(max) { i: Int ->
        if (i % 2 == 0) yield(i)
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

  println("Odd numbers <= 20: ${oddNumbers(10).toList()}")

  val reversedOdds: String =
    oddNumbers(11)
      .toList()
      .reversed()
      //.shuffled()
      .joinToString(", ")
  println("Odd numbers <= 11 reversed: $reversedOdds")

  val zipped: String =
    evenNumbers(6)
      .map { it * it }
      .zip(oddNumbers(6).map { it * it * it })
      .joinToString(", ")

  println("Zipped squared evens and cubed odds: $zipped")
}