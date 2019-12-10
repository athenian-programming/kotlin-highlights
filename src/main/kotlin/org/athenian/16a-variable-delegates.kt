package org.athenian

import kotlin.time.TimedValue
import kotlin.time.measureTimedValue


fun main() {
  class Expensive(val id: String) {
    init {
      println("Creating Expensive object $id")
      Thread.sleep(1000)
    }

    override fun toString() = "Expensive($id)"
  }

  class EagerObject {
    val eagerVal: Expensive = Expensive("eagerVal")
  }

  val tv: TimedValue<EagerObject> = measureTimedValue { EagerObject() }

  println("Took ${tv.duration} to instantiate EagerObject")
}