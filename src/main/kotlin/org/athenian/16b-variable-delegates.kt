package org.athenian

import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
  class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }

    override fun toString() = "Expensive($id)"
  }

  class ByLazyObject {
    val bylazyVal: Expensive by lazy { calcExpensive("byLazyVal") }
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue<ByLazyObject> = measureTimedValue { ByLazyObject() }
  println("Took ${tv.duration} to instantiate LazyObject")

  repeat(3) {
    val ref = measureTimedValue { tv.value.bylazyVal }
    println("byLazy = ${ref.value} took ${ref.duration}")
  }
}