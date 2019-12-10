package org.athenian

import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
  data class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
  }

  data class ByLazyObject(val id: String) {
    val bylazyVal: Expensive by lazy { Expensive(id) }
  }

  val tv: TimedValue<ByLazyObject> = measureTimedValue { ByLazyObject("lazy") }.apply {
    println("Took $duration to instantiate LazyObject")
  }

  repeat(3) {
    measureTimedValue { tv.value.bylazyVal }
      .apply {
        println("byLazyVal = $value and took $duration")
      }
  }
}