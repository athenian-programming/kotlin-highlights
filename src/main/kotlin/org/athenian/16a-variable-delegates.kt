package org.athenian

import kotlin.time.measureTimedValue


fun main() {
  class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }

    override fun toString() = "An Expensive object: $id"
  }

  class EagerObject {
    val eagerVal: Expensive = calculateExpensive("eagerVal")
    private fun calculateExpensive(id: String): Expensive = Expensive(id).also { println("Created -> $it") }
  }


  val eagerTime = measureTimedValue { EagerObject() }

  println("Took ${eagerTime.duration} to instantiate EagerObject")


  class LazyObject {
    val bylazyVal: Expensive by lazy { calculateExpensive("byLazyVal") }
    val lazyVal: Lazy<Expensive> = lazy { calculateExpensive("lazyVal") }

    private fun calculateExpensive(id: String): Expensive = Expensive(id).also { println("Created -> $it") }
  }

  val lazyTime = measureTimedValue { LazyObject() }

  println("Took ${lazyTime.duration} to instantiate LazyObject")


  println("\nReferencing exp.bylazyVal")
  val byLazy: Expensive = lazyTime.value.bylazyVal
  println("byLazy = $byLazy")

  val lazy: Lazy<Expensive> = lazyTime.value.lazyVal
  println("\nlazyVal${if (lazy.isInitialized()) "" else " not"} initialized")
  println("lazy.value = ${lazy.value}")
  println("lazyVal${if (lazy.isInitialized()) "" else "not"} initialized")
}