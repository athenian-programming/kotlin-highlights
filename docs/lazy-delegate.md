# Lazy Delegates


## Eagerly calculated instance variable

<div class="kotlin-code">
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
//sampleStart
  class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
    override fun toString() = "Expensive($id)"
  }

  class EagerObject {
    val eagerVal: Expensive = calcExpensive("eagerVal")
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue&lt;EagerObject> = measureTimedValue { EagerObject() }
  println("Took ${tv.duration} to instantiate EagerObject")
//sampleEnd
}
</div>

## Lazily calculated instance variable using a delegate

<div class="kotlin-code">
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
//sampleStart
  class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
    override fun toString() = "Expensive($id)"
  }

  class ByLazyObject {
    val bylazyVal: Expensive by lazy { calcExpensive("byLazyVal") }
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue&lt;ByLazyObject> = measureTimedValue { ByLazyObject() }
  println("Took ${tv.duration} to instantiate LazyObject")

  repeat(3) {
    val ref = measureTimedValue { tv.value.bylazyVal }
    println("byLazy = ${ref.value} took ${ref.duration}")
  }
//sampleEnd
}
</div>

## Lazily calculated instance variable without a delegate

<div class="kotlin-code">
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
//sampleStart
  class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
    override fun toString() = "Expensive($id)"
  }

  class LazyObject {
    val lazyVal: Lazy&lt;Expensive> = lazy { calcExpensive("lazyVal") }
    private fun calcExpensive(id: String): Expensive = Expensive(id).also { println("Created: $it") }
  }

  val tv: TimedValue&lt;LazyObject> = measureTimedValue { LazyObject() }
  println("Took ${tv.duration} to instantiate LazyObject")
  
  val lazy: Lazy&lt;Expensive> = tv.value.lazyVal
  println("lazyVal${if (lazy.isInitialized()) "" else " not"} initialized")
  println("lazy.value = ${lazy.value}")
  println("lazyVal${if (lazy.isInitialized()) "" else "not"} initialized")
//sampleEnd
}
</div>
