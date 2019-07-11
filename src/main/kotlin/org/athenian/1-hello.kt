package org.athenian

// Functions can be declared outside of classes
// argv is optional
// No semis
// No checked exceptions

fun main() {

    // Type decls come after the variable and function
    val hello: String = "Hello World"

    // String interpolation
    // No System.out prefix
    println("I would like to say: $hello")

    // No more .equals on Strings
    println("Sane treatment for Strings? ${"Hello World" == hello}")

    // Support for multiline strings
    val multi = """
        Kotlin supports multiline
        strings 
    """.trimIndent()

    println(multi)
}

