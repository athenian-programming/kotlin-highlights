package org.athenian

fun main() {
    // Encouraged to think about mutability and
    // default to immutability with vals and vars
    // Type inference
    var a: String = "A string value"
    val b = "Another string Value"

    a = "Can be reassigned"
    // Read-only enforced
    // b = "cannot be reassigned"

    // Smart casts
    val o: Any = a
    val s: String = if (o is String) o else ""
    println(s)

    // No new keyword
    val sb = StringBuilder()
    (1..10).forEach { sb.append(it) }
    println(sb.toString())

    // No primitives or boxing/unboxing
    val i: Int = 9
    val j = i / 3
    val d: Double = 34.54
    val e = d * 45.3
}


