package org.athenian

import kotlin.time.measureTimedValue

fun main() {

  fun aVeryExpensiveMethod(): String {
    Thread.sleep(2000)
    return "Something that was expensive to produce"
  }

  val aMap = mutableMapOf("A" to "Init value")

  val (_, dur0) =
    measureTimedValue {
      aMap.putIfAbsent("A", aVeryExpensiveMethod())
    }

  println("Calling putIfAbsent() took $dur0 [$aMap]")


  val (_, dur1) = measureTimedValue {
    aMap.computeIfAbsent("A") { aVeryExpensiveMethod() }
  }

  println("Calling computeIfAbsent() took $dur1 [$aMap]")

}

