# Kotlin Sequences2


## Using an iterator to generate values
<pre class="kotlin-code" theme="idea" indent="4" style="padding: 36px 0;">
<code>
fun main() {
//sampleStart

  val doReMi: Sequence&lt;String&gt; =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val iter: Iterator&lt;String&gt; = doReMi.iterator()
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")

//sampleEnd
}
</code>


## Using a for loop to generate values
<code>
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
</code>

## Using a Sequence in a call chain
<code>
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
</code>
</pre>