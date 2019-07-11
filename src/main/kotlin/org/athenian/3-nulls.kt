package org.athenian

fun main() {

    // Say good-bye to the dreaded NPE

    // Nullability is built into the type system
    var a: String = "Non-null String"
    var b: String? = "Nullable string"

    //a = null
    //a = b
    //b = null

    // Enforced nullability and smart casts
    if (b != null)
        a = b

    // Elvis operator
    a = b ?: "Found a null value";

    // Trust me, I know what I am doing -- all bets are off for NPE
    a = b!!

    // Null propagation
    val len = b.slice(2..6).slice(0..3).length ?: 0
    println("The length is: $len")
}