package org.athenian

fun main() {

    var a: String = "Non-null String"
    var b: String? = "Nullable string"
    val n: String? = null

    //b = n

    // Enforced nullability and smart casts
    if (b != null)
        a = b

    // Elvis operator
    a = b ?: "Found a null value";

    // Trust me, I know what I am doing
    a = b!!

    println(a)

    // Null prop
    val len = b.slice(2..6).slice(0..3).length ?: 0
    println(len)
}