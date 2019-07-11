package org.athenian

// Functions can be declared outside of classes
// argv is optional
// No semis
// No checked exceptions

fun main() {

    // Type decls come after the variable and function
    val hello: String = "Hello World"

    // No System.out prefix
    // String interpolation
    println("I would like to say: $hello")

    // Sane treatment for Strings
    println("Equal: ${"Hello World" == hello}")
    println("Contains: ${"Hello" in hello}")

    // Support for multiline strings
    val multi = """
        Kotlin supports multiline
        strings 
    """.trimIndent()

    println(multi)
}

