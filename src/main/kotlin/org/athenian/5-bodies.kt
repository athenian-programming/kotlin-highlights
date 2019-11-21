package org.athenian

// Block body -- more than one statement
fun addBB(i: Int, j: Int): Int {
  return i + j
}

// Expression body -- single statements
fun addEB(i: Int, j: Int) = i + j

fun ifExprBB(i: Int): String {
  return if (i > 10)
    "Above"
  else
    "Below"
}

// Most concise
fun ifExprEB(i: Int) = if (i > 10) "Above" else "Below"

fun main() {
  println("Result of addBB(3, 4) = ${addBB(3, 4)}")
  println("Result of addEB(5, 6) = ${addEB(5, 6)}")

  println("Result of ifExprBB(12) = ${ifExprBB(12)}")
  println("Result of ifExprEB(8) = ${ifExprEB(8)}")
}