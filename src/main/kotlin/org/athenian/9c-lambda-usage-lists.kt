package org.athenian

fun main() {

    // The long way
    val myList0 = mutableListOf<String>()
    for (i in 0 until 10)
        myList0.add("A val for item $i")
    println("myList0 = $myList0")

    // Equivalent with lambda
    fun <T> myList(count: Int, block: (i: Int) -> T): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until count)
            list.add(block(i))
        return list
    }

    val myList1 = myList(10) { i -> "A val for item $i" }
    println("myList1 = $myList1")

    // The built-in kotlin version
    val myList2 = List(10) { i -> "A val for item $i" }
    println("myList2 = $myList2")
}