# Kotlin Sequences


<pre class="kotlin-code" theme="idea" indent="4" style="padding: 36px 0;"><code>

fun main() {
//sampleStart

  val doReMi =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val iter = doReMi.iterator()
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")
  println("Note: ${iter.next()}")

//sampleEnd
}


fun main() {
//sampleStart

  val doReMi =
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

fun main() {
//sampleStart

  val doReMi =
    sequence {
      listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
        .forEach {
          yield(it)
        }
    }

  val everyOther =
    doReMi
      .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
      .filter { it.isNotEmpty() }
      .toList()

  println("Every other note: $everyOther")

//sampleEnd
}
</code></pre>
