package org.athenian

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {

  class EventNumbersOnly(var intValue: Int = 0) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = intValue

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
      require(value % 2 != 0) { "Even numbers only please!" }
      intValue = value
    }
  }

  class DelegateExample() {
    var evenNums: Int by Delegates.observable(0) { prop, old, new ->
      require(new % 2 != 0) { "Even numbers only please!" }
    }
  }

  DelegateExample()
    .apply {
      evenNums = 2
      println(evenNums)
      evenNums = 3
      println(evenNums)
    }
}