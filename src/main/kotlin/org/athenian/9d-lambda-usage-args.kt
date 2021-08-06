package org.athenian

import kotlin.time.measureTime

fun main() {

  fun aVeryExpensiveCall(): String {
    Thread.sleep(2000)
    return "Something that was expensive to produce"
  }

  fun printValue(printIt: Boolean, str: String) {
    if (printIt)
      println(str)
  }

  fun printValue(printIt: Boolean, block: () -> String) {
    if (printIt) {
      val str = block()
      println(str)
    }
  }

  val dur0 = measureTime {
    printValue(true, aVeryExpensiveCall())
    printValue(true) { aVeryExpensiveCall() }
  }

  println("Calling methods with true took $dur0")

  val dur1 = measureTime {
    printValue(false, aVeryExpensiveCall())
    printValue(false) { aVeryExpensiveCall() }
  }

  println("Calling methods with false took $dur1")
}
