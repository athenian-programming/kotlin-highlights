package org.athenian

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {

  class DelegateExample() {
    var watchedNum: Int by Delegates.observable(0) { prop, old, new ->
      println("Changing \"${prop.name}\" from $old to $new")
    }

    var evenNum: Int by Delegates.vetoable(0) { prop: KProperty<*>, old: Int, new: Int ->
      println("Attempting to change \"${prop.name}\" from $old to $new")
      // require(new % 2 != 0) { "Even numbers only please!" }
      new % 2 == 0
    }
  }

  DelegateExample()
    .apply {

      watchedNum = 5
      watchedNum = 6

      evenNum = 2
      println("evenNum = $evenNum")
      evenNum = 3
      println("evenNum = $evenNum")
    }
}