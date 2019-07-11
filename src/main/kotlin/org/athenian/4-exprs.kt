package org.athenian

// Everything is an expression!

fun main() {
    val i = 6

    val ifResult =
        if (i == 6) {
            println("Found equal to 6")
            "Equal"
        } else {
            println("Found not equal to 6")
            "Not equal"
        }

    // when is a super switch
    val whenResult =
        when {
            i < 10 -> "Below 10"
            i == 10 -> "Equal to 10"
            i > 10 -> "Above 10"
            else -> throw IllegalStateException()
        }

    println("$ifResult and $whenResult")
}