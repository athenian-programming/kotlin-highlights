package org.athenian

class Thing(val str: String = "") {

    operator fun plus(other: String): Thing = Thing(str + other)

    operator fun plus(other: Int): Thing = Thing(str + other)

    operator fun dec(): Thing = Thing(str.split(" ").dropLast(1).joinToString(" "))

    override fun toString(): String = "Thing = $str"
}

operator fun Int.times(str: String) = List(this) { str }.joinToString("")

fun main() {
    var t = Thing()

    t = t + "Something"
    println(t)

    t += " else "
    println(t)

    t += 545
    println(t)

    t--
    println(t)

    // Adding operators to existing types with extension function
    println(3 * "Hello")
}