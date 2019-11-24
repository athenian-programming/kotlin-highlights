package org.athenian

fun main() {
  data class Person(var first: String = "", var last: String = "", var age: Int = 0)

  // Without a scope function
  val p1 = Person()
  p1.first = "Mary"
  p1.last = "Jones"
  p1.age = 22
  println(p1)

  // With function
  val p2: Person = Person()
  with(p2) {
    first = "Anh"
    last = "Truong"
    age = 12
  }
  println(p2)

  // Apply function
  val p3: Person =
    Person()
      .apply {
        first = "Patty"
        last = "Smith"
        age = 5
      }
  println(p3)

  // Also function
  val p4: Person =
    Person()
      .also {
        it.first = "Mindy"
        it.last = "Nyberg"
        it.age = 42
      }
  println(p4)

  // Run function
  val p5: String =
    Person()
      .run {
        first = "Bill"
        last = "Jackson"
        age = 42
        toString().toUpperCase()
      }
  println(p5)

  // Let function
  val p6: String =
    Person()
      .let {
        it.first = "Mindy"
        it.last = "Nyberg"
        it.age = 42
        it.toString().toLowerCase()
      }
  println(p6)

  // Scope functions be used in call chains
  val numberList: MutableList<Double> = mutableListOf()
  numberList
    .also { println("Populating the list $it") }
    .apply {
      add(2.71)
      add(3.14)
      add(1.0)
    }
    .also { println("Sorting the list $it") }
    .apply { sort() }
    .also { println("Sorted the list $it") }
}