package org.athenian

// Extension Properties and Functions -- ability to extend classes without subclassing

// Extension property
val Int.isEven: Boolean
    get() = this % 2 == 0

// Extension function
fun Int.double(): Int = this * this

// Extension function
fun String.mixCase(): String {
    return this.toList()
        .mapIndexed { i: Int, c: Char ->
            if (i.isEven) c.toLowerCase() else c.toUpperCase()
        }
        .joinToString(separator = "")
}

// Extension function with params
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
    println("5.double() = ${5.double()}")

    println((0..5).reversed().map { "$it is ${if (it.isEven) "Even" else "Odd"}" })

    println("mixCase() = ${"ThisISaTEST".mixCase()}")
    println("halfCase() = ${"ThisISaTEST".halfCase()}")
    println("halfCase(false) = ${"ThisISaTEST".halfCase(false)}")
}