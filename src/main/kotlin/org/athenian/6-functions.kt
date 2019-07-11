package org.athenian

// Block body -- more than one statement
fun addBB(i: Int, j: Int): Int {
    return i + j
}

// Expression body -- single statements
fun addEB(i: Int, j: Int) = i + j

fun ifExprBB(i: Int): String {
    if (i > 10)
        return "Above"
    else
        return "Below"
}

// if stmts return values
fun ifExprEB1(i: Int): String {
    val retval =
        if (i > 10) {
            println("Found above")
            "Above"
        } else {
            println("Found below")
            "Below"
        }

    return retval
}

// Most concise
fun ifExprEB2(i: Int) = if (i > 10) "Above" else "Below"

fun main() {
    println("Result of addBB(3, 4) = ${addBB(3, 4)}")
    println("Result of addEB(5, 6) = ${addEB(5, 6)}")

    println("Result of ifExprBB(12) = ${ifExprBB(12)}")
    println("Result of ifExprEB1(7) = ${ifExprEB1(7)}")
    println("Result of ifExprEB2(8) = ${ifExprEB2(8)}")
}