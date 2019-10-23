package org.athenian

fun main() {

    fun aVeryExpensiveCall1(): String {
        Thread.sleep(2000)
        return "Something that was expensive to produce"
    }

    fun aVeryExpensiveCall2(): String {
        Thread.sleep(1000)
        return "Something that was expensive to produce"
    }

    val start0 = System.currentTimeMillis()
    aVeryExpensiveCall1()
    aVeryExpensiveCall1()
    aVeryExpensiveCall2()
    val time0 = System.currentTimeMillis() - start0
    println("Calling methods took ${time0}ms")

    val start1 = System.currentTimeMillis()
    aVeryExpensiveCall1()
    aVeryExpensiveCall2()
    aVeryExpensiveCall2()
    val time1 = System.currentTimeMillis() - start1
    println("Calling methods took ${time1}ms")


    fun myTimer(block: () -> Unit): Long {
        val start = System.currentTimeMillis()
        block()
        return System.currentTimeMillis() - start
    }

    val t0 = myTimer {
        aVeryExpensiveCall1()
        aVeryExpensiveCall1()
        aVeryExpensiveCall2()
    }
    println("Calling methods took ${t0}ms")

    val t1 = myTimer {
        aVeryExpensiveCall1()
        aVeryExpensiveCall2()
        aVeryExpensiveCall2()
    }
    println("Calling methods took ${t1}ms")

}
