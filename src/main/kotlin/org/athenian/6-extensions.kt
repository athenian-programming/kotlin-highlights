package org.athenian

// Extension Properties and Functions -- ability to extend classes without subclassing

val Int.isEven: Boolean
    get() = this % 2 == 0

fun String.mixCase(): String {
    val sb = StringBuilder()
    this.forEachIndexed { i, c ->
        sb.append(if (i.isEven) c.toLowerCase() else c.toUpperCase())
    }
    return sb.toString()
}

fun main() {
    println("5.isEven = ${5.isEven}")

    println((0..5).reversed().map { "$it is ${if (it.isEven) "Even" else "Odd"}" })

    println("This IS a Test".mixCase())
}