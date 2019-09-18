package org.athenian

fun main() {
    // Encouraged to think about mutability
    // Default to immutability with vals and vars
    var a: String = "A string value"
    val b: String = "Another string Value"

    a = "Can be reassigned"
    // Read-only enforced
    //b = "cannot be reassigned"

    // Type inference
    val t = "A String"
    val u = t

    // No primitives or boxing/unboxing
    val i = 9
    val j = i / 3
    val d = 34.54
    val e = d * 45.3

    // Smart casts
    val o: Any = a
    val s: String = if (o is String) o else ""
    println(s)
}


