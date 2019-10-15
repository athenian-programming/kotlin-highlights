package org.athenian

fun main() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")

    words.count()
    words.get(2)
    words.contains("quick")

    val any = words.any { it.length > 3 }
    val all = words.all { it.length > 3 }
    val none = words.none { it.length == 1 }

    val first = words.first { it.length == 3 }
    val last = words.last { it.length == 3 }

    val count = words.count { it.contains("o") }

    val longWords = words.filter { it.length > 3 }

    val takeWhile = words.takeWhile { it != "over" }

    val partitionedWords = words.partition { it.length > 3 }

    //words.forEach { println(it.length) }

    println(takeWhile)
}

