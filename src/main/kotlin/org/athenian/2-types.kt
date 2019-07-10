package org.athenian

fun main() {

    // Encouraged to think about mutability and default to immutability
    // vals and vars
    var a: String = "A string value"
    val b: String = "Another string Value"

    a = "can be reassigned"
    // Read-only enforced
    // b = "cannot be reassigned"


    // Type inference -- super smart compiler
    var c = b


    // No primitives
    val i: Int = 9
    val j = 8
    val f = 34.54


    // No new keyword
    val sb = StringBuilder()
    (1..10).forEach { sb.append(it) }
    val result = sb.toString()
    println(result)


    // Smart casts
    val o: Any = result
    val s: String = if (o is String) o else ""
    println(s)
}


