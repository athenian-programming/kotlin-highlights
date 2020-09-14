package snippets

fun main() {

  val double = { i: Int -> i * 2 }

  val triple: (Int) -> Int = { it * 3 }

  fun sumOfActions(i: Int, actions: List<(Int) -> Int>): Int {
    return actions.map { it(i) }.sum()
  }

  println(sumOfActions(4, listOf(double, double))) // produces 16
  println(sumOfActions(4, listOf(double, triple))) // produces 20

  println(sumOfActions(5, listOf({ it + 2 }, { it + 3 }))) // produces 15
  println(sumOfActions(5, listOf(double, { it + 3 }))) // produces 18


}




