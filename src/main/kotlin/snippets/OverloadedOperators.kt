package snippets


fun main() {
  //val t1 = 3 * "Hello"
  //val p1 = 3 + "Hello"

  operator fun Int.times(str: String) = List(this) { str }.joinToString("")

  operator fun Int.plus(str: String) = "$this$str"

  val t2 = 3.times("Hello") // "HelloHelloHello"
  val t3 = 3 * "Hello"      // "HelloHelloHello"

  val p2 = 3.plus("Hello")  // "3Hello"
  val p3 = 3 + "Hello"      // "3Hello"

  println(t2)
  println(p2)
}




