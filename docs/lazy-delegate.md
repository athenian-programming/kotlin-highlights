# Lazy Delegates


## Eagerly calculated instance variable

<div class="kotlin-code">
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
//sampleStart
  data class Expensive(val id: String)  {
    init {
      Thread.sleep(1000)
    }
  }

  data class EagerObject(val id: String) {
    val eagerVal: Expensive = Expensive(id)
  }

  measureTimedValue { EagerObject("eager") }
    .apply { 
      println("Took $duration to instantiate $value")
  }
//sampleEnd
}
</div>

## Lazily calculated instance variable using a delegate

<div class="kotlin-code">
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

fun main() {
//sampleStart
  data class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
  }

  data class ByLazyObject(val id: String) {
    val bylazyVal: Expensive by lazy { Expensive(id) }
  }

  val tv: TimedValue&lt;ByLazyObject> = measureTimedValue { ByLazyObject("lazy") }.apply {
    println("Took $duration to instantiate LazyObject")
  }

  repeat(3) {
    measureTimedValue { tv.value.bylazyVal }
      .apply {
        println("byLazyVal = $value and took $duration")
    }
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
  data class Expensive(val id: String) {
    init {
      Thread.sleep(1000)
    }
  }

  data class LazyObject(val id: String) {
    val lazyVal: Lazy&lt;Expensive> = lazy { Expensive(id) }
  }

  measureTimedValue { LazyObject("byLazy") }
    .apply {
      println("Took $duration to instantiate $value")

      val lazy: Lazy&lt;Expensive> = value.lazyVal
      println("lazyVal${if (lazy.isInitialized()) "" else " not"} initialized")
      println("lazy.value = ${lazy.value}")
      println("lazyVal${if (lazy.isInitialized()) "" else "not"} initialized")
  }
//sampleEnd
}
</div>
