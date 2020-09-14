package snippets


fun String.mixCase(): String {
  return this.toList()
    .mapIndexed { i: Int, c: Char ->
      if (i.isEven) c.toLowerCase() else c.toUpperCase()
    }
    .joinToString(separator = "")
}

val Int.isEven: Boolean
  get() = this % 2 == 0

fun <T> T.isNull() = this == null

fun main() {
  println("This is a test".mixCase())
  println(3.isEven)
  println(null.isNull())
  println("Hello".isNull())
}




