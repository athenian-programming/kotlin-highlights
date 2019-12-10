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

  class EagerObject {
    val eo: Expensive = calcExpensive("eagerVal")
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue<EagerObject> = measureTimedValue { EagerObject() }

  println("Took ${tv.duration} to instantiate EagerObject")
}