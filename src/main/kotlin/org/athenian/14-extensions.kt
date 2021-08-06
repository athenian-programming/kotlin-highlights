package org.athenian

import java.util.*

// Extension Properties and Functions -- ability to extend classes without subclassing

// Extension property for Int
val Int.isEven: Boolean
  get() = this % 2 == 0

// Extension function for Int
fun Int.double(): Int = this + this

// Extension function for String
fun String.mixCase(): String {
  return this.toList()
    .mapIndexed { i: Int, c: Char ->
      if (i.isEven) c.lowercaseChar() else c.uppercaseChar()
    }
    .joinToString(separator = "")
}

// Extension function for String with params
fun String.halfCase(lowerFirst: Boolean = true): String {
  val firstHalf = this.slice(0..length / 2)
  val secondHalf = this.slice(length / 2 until length)
  return if (lowerFirst)
    firstHalf.lowercase(Locale.getDefault()) + secondHalf.uppercase(Locale.getDefault())
  else
    firstHalf.uppercase(Locale.getDefault()) + secondHalf.lowercase(Locale.getDefault())
}

// Extension function for any type of object
fun <T> T.foo() = "foo $this"

// Extension function for constrained generic type
fun <T : Number> T.doubleIt(): Double = this.toDouble() * 2

fun main() {
  println((0..5).map { "$it is ${if (it.isEven) "Even" else "Odd"}" })

  println("5.double() = ${5.double()}")

  println("mixCase() = ${"ThisISaTEST".mixCase()}")

  println("halfCase() = ${"ThisISaTEST".halfCase()}")
  println("halfCase(false) = ${"ThisISaTEST".halfCase(false)}")

  println("Extension function for any object receiver: ${"Test".foo()}")
  println("Extension function for a number receiver: ${4.doubleIt()} and ${32.1.doubleIt()}")
}