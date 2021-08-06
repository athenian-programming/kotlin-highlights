package org.athenian

import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger
import kotlin.reflect.KProperty

fun main() {

  class MonitoredString(var content: String = "") {
    private val counter = AtomicInteger(0)

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
      val cnt = counter.incrementAndGet()
      return "$content [Accessed $cnt time${if (cnt == 1) "" else "s"}]"
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
      content = "${LocalDateTime.now()}: $value"
    }
  }

  class DelegateExample {
    var strVal: String by MonitoredString()
  }

  DelegateExample()
    .apply {
      strVal = "A first value"
      println("strVal = $strVal")
      strVal = "A second value"
      println("strVal = $strVal")
      println("strVal = $strVal")
    }
}