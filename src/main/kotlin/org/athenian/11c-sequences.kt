package org.athenian

fun main() {


  val seqCount: Sequence<Int> =
    sequence {
      (0..10).forEach { yield(it) }
    }

  println(seqCount.toList())


  val items: List<Int> = (0..10).toList()
  var cnt = 0
  val genSeqCount: Sequence<Int> =
    generateSequence {
      if (cnt <= 10)
        items[cnt++]
      else
        null
    }

  println(genSeqCount.toList())

  var count = 0
  val countUp: Sequence<Int> =
    generateSequence {
      (count++).takeIf { it <= 10 }
    }
  println(countUp.toList())


  val seededGenSeqCount: Sequence<Int> =
    generateSequence(0) {
      it + 1
    }

  println(seededGenSeqCount.take(11).toList())


  // Borrowed from: https://medium.com/@hadiyarajesh/power-of-kotlin-generate-fibonacci-series-in-6-lines-of-code-with-lambdas-and-higher-order-91b85998cab7

  val fibonacciPairs: Sequence<Pair<Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  println("Fibonacci pairs: ${fibonacciPairs.take(10).joinToString()}")
  println("Fibonacci numbers: ${fibonacciPairs.take(10).map { it.first }.joinToString()}")


  val fibonacciSequence: Sequence<Int> = fibonacciPairs.map { it.first }

  println("Fibonacci numbers: ${fibonacciSequence.take(10).joinToString()}")
}

