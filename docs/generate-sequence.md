# Use of generateSequence {} 

## Fibonacci Pairs using `sequence {}` 

* F(n) = F(n-1) + F(n-2) 

<div class="kotlin-code">
fun main() {
//sampleStart
  fun fibonacciSeq() =
    sequence {
      var terms = Pair(0, 1)
      while (true) {
        yield(terms.first)
        terms = Pair(terms.second, terms.first + terms.second)
      }
    }

  println("Fibonacci numbers: ${fibonacciSeq().take(15).joinToString()}")
//sampleEnd
}
</div>


## `generateSequence {}`

* No explicit `yield` with `generateSequence` block
* Sequence ends on null

<div class="kotlin-code">
fun main() {
//sampleStart
  val items: List&lt;Int> = (0..10).toList()
  var cnt = 0
  val genSeqCount: Sequence&lt;Int> =
    generateSequence {
      if (cnt <= 10) items[cnt++] else null
    }

  println(genSeqCount.toList())
//sampleEnd
}
</div>


## `generateSequence {}` with a predicate

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

## Seeded `generateSequence {}`

* Seed value used in initial call, subsequent calls use the most recent return value.

<div class="kotlin-code">
fun main() {
//sampleStart
  val seededGenSeqCount: Sequence&lt;Int> =
    generateSequence(0) {
      it + 1
    }

  println(seededGenSeqCount.take(11).toList())
//sampleEnd
}
</div>


## Fibonacci Pairs with seeded `generateSequence {}`

* F(n) = F(n-1) + F(n-2) 

<div class="kotlin-code">
fun main() {
//sampleStart
  val fibonacciPairs: Sequence&lt;Pair&lt;Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  println("Fibonacci pairs: ${fibonacciPairs.take(15).joinToString("\n")}")
  
  //println("Fibonacci numbers: ${fibonacciPairs.take(15).map { it.first }.joinToString()}")
//sampleEnd
}
</div>

## Fibonacci Sequence from Fibonacci Pairs

<div class="kotlin-code">
fun main() {
//sampleStart
  val fibonacciPairs: Sequence&lt;Pair&lt;Int, Int>> =
    generateSequence(Pair(0, 1)) {
      Pair(it.second, it.first + it.second)
    }

  val fibonacciSequence: Sequence&lt;Int> = fibonacciPairs.map { it.first }

  println("Fibonacci numbers: ${fibonacciSequence.take(15).joinToString()}")
//sampleEnd
}
</div>


