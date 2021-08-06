package snippets


fun String.mixCase(): String {
  return this.toList()
    .mapIndexed { i: Int, c: Char ->
      if (i.isEven) c.lowercaseChar() else c.uppercaseChar()
    }
    .joinToString(separator = "")
}

val Int.isEven: Boolean
  get() = this % 2 == 0

fun <T> T.isNull() = this == null

fun main() {
  println("This is a test".mixCase()) // tHiS Is a tEsT
  println(3.isEven)                   // false
  println(null.isNull())              // true
  println("Hello".isNull())           // false
}




