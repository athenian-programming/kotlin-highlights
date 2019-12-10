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

  class LazyObject {
    val lazyVal: Lazy<Expensive> = lazy { calcExpensive("lazyVal") }
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue<LazyObject> = measureTimedValue { LazyObject() }
  println("Took ${tv.duration} to instantiate LazyObject")

  val lazy: Lazy<Expensive> = tv.value.lazyVal
  println("lazyVal${if (lazy.isInitialized()) "" else " not"} initialized")
  println("lazy.value = ${lazy.value}")
  println("lazyVal${if (lazy.isInitialized()) "" else "not"} initialized")
}