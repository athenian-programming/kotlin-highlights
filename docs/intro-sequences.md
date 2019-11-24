# Kotlin Sequences

## Using an iterator to generate values

<div class="kotlin-code">
fun main() {
//sampleStart
  val doReMi: Sequence&lt;String> =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val iter: Iterator&lt;String> = doReMi.iterator()
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")
//sampleEnd
}
</div>


## Using a for loop to generate values

<div class="kotlin-code">
fun main() {
//sampleStart
  val doReMi: Sequence&lt;String&gt; =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  for (note in doReMi)
    println("Note: $note")
//sampleEnd
}
</div>

## Using a Sequence in a call chain

<div class="kotlin-code">
fun main() {
//sampleStart
  val doReMi: Sequence&lt;String&gt; =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val everyOther: List&lt;String&gt; =
    doReMi
      .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
      .filter { it.isNotEmpty() }
      .toList()

  println("Every other note: $everyOther")
//sampleEnd
}
</div>
