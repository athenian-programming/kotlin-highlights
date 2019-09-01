package org.athenian

class Thing(val str: String = "") {

    operator fun plus(other: String): Thing = Thing(str + other)

    operator fun plus(other: Int): Thing = Thing(str + other)

    operator fun unaryMinus(): Thing = Thing(str.split(" ").dropLast(1).joinToString(" "))

    override fun toString(): String = "Thing = $str"
}

fun main() {
    var t = Thing()

    t = t + "Something"
    println(t)

    t += " else "
    println(t)

    t += 545
    println(t)

    t = -t
    println(t)
}