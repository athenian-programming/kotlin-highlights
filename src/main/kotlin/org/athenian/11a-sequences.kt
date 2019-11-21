package org.athenian

fun main() {

  val doReMi =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val iter = doReMi.iterator()
  println(iter.next())
  println(iter.next())

  for (note in doReMi)
    println(note)


  val everyOther =
    doReMi
      .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
      .filter { it.isNotEmpty() }
      .toList()

  println("Every other note: $everyOther")
}