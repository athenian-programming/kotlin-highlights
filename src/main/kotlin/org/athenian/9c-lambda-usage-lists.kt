package org.athenian

fun main() {

    // The long way
    val aList = mutableListOf<String>()
    for (i in 0 until 10)
        aList.add("A val for item $i")

    println("aList = $aList")


    // String Lists
    fun myStringList(count: Int, block: (i: Int) -> String): List<String> {
        val list = mutableListOf<String>()
        for (i in 0 until count)
            list += block(i)
        return list
    }

    val strList = myStringList(10) { i -> "A val for item $i" }
    println("strList = $strList")


    // Int Lists
    fun myIntList(count: Int, block: (i: Int) -> Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 until count)
            list += block(i)
        return list
    }

    val intList = myIntList(10) { i -> i * i }
    println("intList = $intList")


    // Generic Lists
    fun <T> myList(count: Int, block: (i: Int) -> T): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until count)
            list += block(i)
        return list
    }

    val myList1 = myList(10) { i -> "A val for item $i" }
    println("myList1 = $myList1")


    // The built-in kotlin version
    val myList2 = List(10) { i -> "A val for item $i" }
    println("myList2 = $myList2")

    val myInts = List(10) { i -> i * i }
    println("myInts = $myInts")
}