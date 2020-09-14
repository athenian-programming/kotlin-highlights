package snippets

import java.security.InvalidParameterException

fun calc(operator: String = "+", a: Int, b: Int) {
  val result =
    try {
      when (operator) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> throw InvalidParameterException()
      }
    } catch (e: InvalidParameterException) {
      println("Invalid operator: $operator")
      -1
    }

  println("result = $result")
}



