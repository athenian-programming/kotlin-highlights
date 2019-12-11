# Observable Delegates

## Delegates.observable and Delegates.vetoable

<div class="kotlin-code">
import kotlin.reflect.KProperty

fun main() {
//sampleStart
  class DelegateExample() {
    var watchedNum: Int by Delegates.observable(0) { prop, old, new ->
      println("Changing \"${prop.name}\" from $old to $new")
    }

    var evenNum: Int by Delegates.vetoable(0) { prop: KProperty&lt;*>, old: Int, new: Int ->
      // require(new % 2 != 0) { "Even numbers only please!" }
      new % 2 == 0
    }
  }

  DelegateExample()
    .apply {
      watchedNum = 5
      watchedNum = 6

      evenNum = 2
      println("evenNum = $evenNum")
      evenNum = 3
      println("evenNum = $evenNum")
    }
//sampleEnd
}
</div>