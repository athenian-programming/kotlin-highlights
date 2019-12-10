package org.athenian

import kotlin.time.measureTimedValue

fun main() {
  data class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
  }

  data class LazyObject(val id: String) {
    val lazyVal: Lazy<Expensive> = lazy { Expensive(id) }
  }

  measureTimedValue { LazyObject("byLazy") }
    .apply {
      println("Took $duration to instantiate $value")

      val lazy: Lazy<Expensive> = value.lazyVal
      println("lazyVal${if (lazy.isInitialized()) "" else " not"} initialized")
      println("lazy.value = ${lazy.value}")
      println("lazyVal${if (lazy.isInitialized()) "" else "not"} initialized")
    }
}