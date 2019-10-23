package org.athenian

import mu.KLogging
import kotlin.time.measureTimedValue

class MyClass() {

    fun aVeryExpensiveMethod(): String {
        Thread.sleep(2000)
        return "Something that was expensive to produce"
    }

    fun method1() {
        logger.debug("Logging message in method1 [${aVeryExpensiveMethod()}]")
        logger.debug { "This is a logging message in method1 [${aVeryExpensiveMethod()}]" }
    }

    fun method2() {
        logger.error("Logging message in method2 [${aVeryExpensiveMethod()}]")
        logger.error { "This is a logging message in method2 [${aVeryExpensiveMethod()}]" }
    }

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            val (vals, dur) = measureTimedValue {
                val t = MyClass()
                t.method1()
                t.method2()
            }
            println("Calling methods took $dur")
        }
    }
}