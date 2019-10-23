package org.athenian

fun main() {

    for (i in 0..10)
        println(i)

    for (i in 0 until 10) {
        println(i * i)
        println(i * i)
    }

    fun myRepeat(count: Int, block: (i: Int) -> Unit) {
        for (i in 0 until count)
            block(i)
    }

    myRepeat(10) {
        println(it)
    }
}