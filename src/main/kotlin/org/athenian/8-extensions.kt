package org.athenian

// Extension Properties and Functions -- ability to extend classes without subclassing

// Extension property for Int
val Int.isEven: Boolean
    get() = this % 2 == 0

// Extension function for Int
fun Int.double(): Int = this * this

// Extension function for String
fun String.mixCase(): String {
    return this.toList()
        .mapIndexed { i: Int, c: Char ->
            if (i.isEven) c.toLowerCase() else c.toUpperCase()
        }
        .joinToString(separator = "")
}

// Extension function for String with params
fun String.halfCase(lowerFirst: Boolean = true): String {
    val firstHalf = this.slice(0..this.length / 2)
    val secondHalf = this.slice(this.length / 2..this.length - 1)
    return if (lowerFirst)
        firstHalf.toLowerCase() + secondHalf.toUpperCase()
    else
        firstHalf.toUpperCase() + secondHalf.toLowerCase()
}

fun main() {
    println("5.isEven = ${5.isEven}")
    println((0..5).map { "$it is ${if (it.isEven) "Even" else "Odd"}" })

    println("5.double() = ${5.double()}")

    println("mixCase() = ${"ThisISaTEST".mixCase()}")

    println("halfCase() = ${"ThisISaTEST".halfCase()}")
    println("halfCase(false) = ${"ThisISaTEST".halfCase(false)}")
}