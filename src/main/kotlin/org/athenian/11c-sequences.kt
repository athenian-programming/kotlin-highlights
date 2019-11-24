package org.athenian

fun main() {

  val seqCount1: Sequence<Int> =
    sequence {
      (0..10).forEach { yield(it) }
    }

  println(seqCount1.toList())


  val items: List<Int> = (0..10).toList()
  var cnt = 0
  val seqCount2: Sequence<Int> =
    generateSequence {
      if (cnt <= 10)
        items[cnt++]
      else
        null
    }

  println(seqCount2.toList())

  var count = 0
  val countUp: Sequence<Int> =
    generateSequence {
      (count++).takeIf { it <= 10 }
    }
  println(countUp.toList())

  // Borrowed from: https://medium.com/@hadiyarajesh/power-of-kotlin-generate-fibonacci-series-in-6-lines-of-code-with-lambdas-and-higher-order-91b85998cab7

  // Calculating Fn  = Fn-1 + Fn-2 and mapping to return Pair<Int,Int>
  val fibonacciPairs: Sequence<Pair<Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  println("Fibonacci pairs: ${fibonacciPairs.take(10).joinToString()}")
  println("Fibonacci numbers: ${fibonacciPairs.take(10).map { it.first }.joinToString()}")


  val fibonacciSequence: Sequence<Int> = fibonacciPairs.map { it.first }

  println("Fibonacci numbers: ${fibonacciSequence.take(10).joinToString()}")
}

