# Object Delegates

## Managed instance variables

<div class="kotlin-code">
import kotlin.reflect.KProperty

fun main() {
//sampleStart
  class EventNumbersOnly(var intValue: Int = 0) {

    operator fun getValue(thisRef: Any?, property: KProperty&lt;*>): Int = intValue

    operator fun setValue(thisRef: Any, property: KProperty&lt;*>, value: Int) {
      require(value % 2 != 0) { "Even numbers only please!" }
      intValue = value
    }
  }

  class DelegateExample() {
    var evenNums: Int by EventNumbersOnly()
  }

  DelegateExample()
    .apply {
      evenNums = 2
      println(evenNums)
      evenNums = 3
      println(evenNums)
    }
//sampleEnd
}
</div>