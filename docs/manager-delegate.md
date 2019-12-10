# Object Delegates

## Managed instance variables

<div class="kotlin-code">
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger
import kotlin.reflect.KProperty

fun main() {
//sampleStart
  class MonitoredString(var content: String = "") {
    private val counter = AtomicInteger(0)

    operator fun getValue(thisRef: Any?, property: KProperty&lt;*>): String {
      val cnt = counter.incrementAndGet()
      return "$content [Accessed $cnt time${if (cnt == 1) "" else "s"}]"
    }

    operator fun setValue(thisRef: Any, property: KProperty&lt;*>, value: String) {
      content = "${LocalDateTime.now()}: $value"
    }
  }

  class DelegateExample() {
    var desc: String by MonitoredString()
  }

  DelegateExample()
    .apply {
      desc = "A new value"
      println("desc = $desc")
      desc = "A second new value"
      println("desc = $desc")
      println("desc = $desc")
    }
//sampleEnd
}
</div>