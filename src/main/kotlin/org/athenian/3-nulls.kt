package org.athenian

fun main() {

    // Say good-bye to the dreaded NPE

    var a: String = "Non-null String"
    var b: String? = "Nullable string"

    //b = null

    // Enforced nullability and smart casts
    if (b != null)
        a = b

    // Elvis operator
    a = b ?: "Found a null value";

    // Trust me, I know what I am doing -- all bets are off for NPE
    a = b!!

    // String interpolation
    println("Variable a = $a and it has a length of ${a.length}")

    // Null propagation
    val len = b.slice(2..6).slice(0..3).length ?: 0
    println("The legnth is: $len")
}