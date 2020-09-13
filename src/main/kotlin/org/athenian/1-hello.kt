package org.athenian

// Functions can be declared outside of classes
// No one class per file restriction
// argv on main() is optional
// No semis
// No new with constructor calls
// No checked exceptions

fun main() {
  // Type decls come after the variable and function
  val hello = "Hello World"
  val name: String = "Pete"

  // String templates
  println("I would like to say: $hello")
  println("My greeting had a length of: ${hello.length}")

  // Sane treatment for Strings
  println("Equal: ${"Hello World" == hello}")
  println("Contains: ${"Hello" in listOf(hello, name)}")

  // Support for multiline strings
  val multi = """
        Kotlin supports 
        multiline strings 
    """.trimIndent()
  println(multi)
}