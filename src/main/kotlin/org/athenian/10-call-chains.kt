package org.athenian

import java.lang.Thread.sleep
import kotlin.time.measureTimedValue
import kotlin.time.seconds

fun main() {

  val intVals = listOf(0, 2, 5, 6, 4, 7, 8, -1, 12, 14)

  fun nonLambdaCalculation(inputList: List<Int>): Int {
    var result = 0
    for (input in inputList) {
      if (input == -1) break
      if (input % 2 == 0) {
        result += input * input
      }
    }
    return result
  }

  println(nonLambdaCalculation(intVals))

  fun lambdaCalculation(inputList: List<Int>): Int =
    inputList
      .takeWhile { it != -1 }
      .filter { it % 2 == 0 }
      .map { it * it }
      .sum()

  println(lambdaCalculation(intVals))

  //System.exit(1)

  (1..10)
    .onEach { println("Working on $it") }
    .take(5)
    .map { it * 5 }
    .onEach { println(it) }
    .mapIndexed { i, v -> "A string using $v at index $i" }
    .forEach { println("Looking at [$it]") }

  // Peak at Sequences
  "This is a list of words".split(" ")
    .asSequence()
    .onEach { println("First: $it") }
    .onEach { println("Second: $it") }
    .forEach { println("Third: $it") }


  val (_, dur) = measureTimedValue {
    "Another set of words".split(" ")
      .asSequence()
      .onEach { sleep(2.seconds.toLongMilliseconds()) }
      .onEach { println("First: $it") }
      //.take(1)
      .onEach { println("Second: $it") }
      .forEach { println("Third: $it") }
  }
  println("Elapsed time: $dur")

  // Works with Maps as well
  val map = mutableMapOf("A" to 10, "B" to 11, "C" to 12)

  println("Keys: ${map.keys}")
  println("Values: ${map.values}")
  println("Filter: ${map.filter { entry -> entry.key != "B" }}")
}