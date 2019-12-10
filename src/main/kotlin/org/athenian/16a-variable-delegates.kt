package org.athenian

import kotlin.time.measureTimedValue


fun main() {
  data class Expensive(val id: String) {
    init {
      println("Creating Expensive object")
      Thread.sleep(1000)
    }
  }

  data class EagerObject(val id: String) {
    val eagerVal: Expensive = Expensive(id)
  }

  measureTimedValue { EagerObject("eager") }
    .apply {
      println("Took $duration to instantiate $value")
    }
}