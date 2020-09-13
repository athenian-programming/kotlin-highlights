package org.athenian


fun main() {
  exercise1()
}

fun exercise1() {

  val str = """
    This is 
    a
    very long
    string with
    many lines
    of text.
  """.trimIndent()

  val lines = str.split("\n")

  val result = listOf(lines.first(), lines.last())

  val output = result.joinToString("\n")

  val ppp = str.split("\n").let { listOf(it.first(), it.last()) }.joinToString("\n")
  val mixed = str.split("\n").shuffled().joinToString("\n")
  val everyother = str.split("\n").filterIndexed { index, s -> index % 2 == 1 }.joinToString("\n")

  //println(output)
  println(everyother)
}