# Kotlin Sequences 2

## Even numbers from `repeat()` stmt

<div class="kotlin-code">
fun main() {
//sampleStart
  fun evenNumbers(max: Int): Sequence&lt;Int> =
    sequence {
      repeat(max) { i: Int ->
        if (i % 2 == 0) yield(i)
      }
    }

  for (v in evenNumbers(10))
    println("Val $v")


  val vals: List&lt;Int> = evenNumbers(10).toList()
  println("Even numbers <= 10: ${vals}")
//sampleEnd
}
</div>


## Even numbers from a call chain

<div class="kotlin-code">
fun main() {
//sampleStart
  fun evenNumbers(max: Int): Sequence&lt;Int> =
    sequence {
      (0..max)
        .filter { it % 2 == 0 }
        .forEach { yield(it) }
    }

  println("Even numbers <= 20: ${evenNumbers(10).toList()}")

  fun oddNumbers(max: Int): Sequence&lt;Int> =
    sequence {
      evenNumbers(max - 1)
        .forEach {
          yield(it + 1)
        }
    }

  println("Odd numbers <= 20: ${oddNumbers(10).toList()}")
//sampleEnd
}
</div>


## Combining sequences

* How would you choose randomized instead of reversed in reverseOdds?

<div class="kotlin-code">
fun main() {
  fun evenNumbers(max: Int): Sequence&lt;Int> =
    sequence {
      (0..max)
        .filter { it % 2 == 0 }
        .forEach { yield(it) }
    }

  fun oddNumbers(max: Int): Sequence&lt;Int> =
    sequence {
      evenNumbers(max - 1)
        .forEach {
          yield(it + 1)
        }
    }
    
//sampleStart
  val reversedOdds: String =
    oddNumbers(11)
      .toList()
      .reversed()
      .joinToString(", ")
  println("Odd numbers <= 11 reversed: $reversedOdds")

  val zipped: String =
    evenNumbers(6)
      .map { it * it }
      .zip(oddNumbers(6).map { it * it * it })
      .joinToString(", ")

  println("Zipped squared evens and cubed odds: $zipped")
//sampleEnd
}
</div>


