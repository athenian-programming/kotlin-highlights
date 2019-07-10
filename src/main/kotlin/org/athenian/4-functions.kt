package org.athenian

// Block body
fun addBB(i: Int, j: Int): Int {
    return i + j
}

// Expression body
fun addEB(i: Int, j: Int) = i + j

fun ifExprBB(i: Int): String {
    if (i > 10)
        return "Above"
    else
        return "Below"
}

fun ifExprEB1(i: Int): String {
    return if (i > 10)
        "Above"
    else
        "Below"
}

fun ifExprEB2(i: Int) = if (i > 10) "Above" else "Below"

// when is a super switch
fun whenEB(i: Int) =
    when {
        i < 10 -> "Below"
        i == 10 -> "Equal"
        i > 10 -> "Above"
        else -> "Unknown"
    }

fun main() {
    println("Results of addBB(3, 4) = ${addBB(3, 4)}")
    println("Results of addEB(5, 6) = ${addEB(5, 6)}")

    println("Results of ifExprBB(12) = ${ifExprBB(12)}")
    println("Results of ifExprEB1(7) = ${ifExprEB1(7)}")
    println("Results of ifExprEB2(8) = ${ifExprEB2(8)}")

    println("Results of whenEB(10) = ${whenEB(10)}")
}