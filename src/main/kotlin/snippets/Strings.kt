package snippets

fun main() {
  val hello: String = "Hello World"
  val multi = """
        Kotlin supports 
        multiline strings 
    """.trimIndent()

  println("I would like to say: $hello")
  println("My greeting had a length of: ${hello.length}")

  println("Equals: ${"Hello World" == hello}")
  println("Contains: ${"port" in multi}")
}




