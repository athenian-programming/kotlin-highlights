package org.athenian

// See: https://kotlinlang.org/docs/reference/data-classes.html

fun main() {

  // Regular class decl
  class Person1(var name: String, val age: Int)

  // Data class decl
  data class Person2(var name: String, val age: Int)

  val p1 = Person1("Ramish", 22)
  val p2 = Person1("Ramish", 22)

  val p3 = Person2("Xi", 32)
  val p4 = Person2("Xi", 32)
  val p5 = Person2("Xi", 34)

  // toString() for free
  println("p1=$p1\np2=$p3")

  // destructuring for free
  val (name, age) = p3

  // equals() for free
  println("p1 == p2 -> ${p1 == p2}")
  println("p3 == p4 -> ${p3 == p4}")
  println("p3 == p5 -> ${p3 == p5}")

  // copy() comes for free
  println(p3.copy(name = "Jing"))
}