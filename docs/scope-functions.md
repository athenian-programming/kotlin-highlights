# Scope Functions


<div class="kotlin-code">
fun main() {
//sampleStart
  data class Person(var first: String = "", var last: String = "", var age: Int = 0)

  // Without a scope function
  val p1 = Person()
  p1.first = "Mary"
  p1.last = "Jones"
  p1.age = 22
  println(p1)

  // Apply function
  println(Person().apply {
    first = "Patty"
    last = "Smith"
    age = 5
  })

  // Also function
  println(Person().also { p ->
    p.first = "Mindy"
    p.last = "Nyberg"
    p.age = 42
  })

  // Run function
  val p5: String =
    Person().run {
      first = "Bill"
      last = "Jackson"
      age = 42
      toString().toUpperCase()
    }
  println(p5)

  // Let function
  val p6: String =
    Person().let {
      it.first = "Mindy"
      it.last = "Nyberg"
      it.age = 42
      it.toString().toLowerCase()
    }
  println(p6)

  // With function
  val p2: Person = Person()
  with(p2) {
    first = "Anh"
    last = "Truong"
    age = 12
  }
  println(p2)

  // Scope functions can be used in call chains
  val numberList: MutableList&lt;Double> = mutableListOf()
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
//sampleEnd
}
</div>
