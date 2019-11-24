package org.athenian

fun main() {

  val doReMi: Sequence<String> =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val iter: Iterator<String> = doReMi.iterator()
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")

  for (note in doReMi)
    println("Note: $note")


  val everyOther: List<String> =
    doReMi
      .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
      .filter { it.isNotEmpty() }
      .toList()

  println("Every other note: $everyOther")
}