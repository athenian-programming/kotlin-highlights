# Kotlin Sequences 3

## Simple use of sequence {}

<div class="kotlin-code">
fun main() {
//sampleStart
  val seqCount: Sequence&lt;Int> =
    sequence {
      (0..10).forEach { yield(it) }
    }
  
  println(seqCount.toList())
//sampleEnd
}
</div>


## Simple use of generateSequence {}

<div class="kotlin-code">
fun main() {
//sampleStart
  val items: List&lt;Int> = (0..10).toList()
  var cnt = 0
  val seqCount: Sequence&lt;Int> =
    generateSequence {
      if (cnt <= 10) items[cnt++] else null
    }

  println(seqCount.toList())
//sampleEnd
}
</div>


## Using a call chain within a generateSequence {} 

<div class="kotlin-code">
fun main() {
//sampleStart
  var count = 0
  val countUp: Sequence&lt;Int> =
    generateSequence {
      (count++).takeIf { it <= 10 }
    }
    
  println(countUp.toList())
//sampleEnd
}
</div>


## Fibonacci 1

<div class="kotlin-code">
fun main() {
//sampleStart
  val fibonacciPairs: Sequence&lt;Pair&lt;Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  println("Fibonacci pairs: ${fibonacciPairs.take(10).joinToString("\n")}")
  
  //println("Fibonacci numbers: ${fibonacciPairs.take(10).map { it.first }.joinToString()}")
//sampleEnd
}
</div>

## Fibonacci 2

<div class="kotlin-code">
fun main() {
//sampleStart
  val fibonacciPairs: Sequence&lt;Pair&lt;Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  val fibonacciSequence: Sequence&lt;Int> = fibonacciPairs.map { it.first }

  println("Fibonacci numbers: ${fibonacciSequence.take(10).joinToString()}")
//sampleEnd
}
</div>


