package org.athenian

typealias FIntToString = (Int) -> String
typealias FIntToInt = (Int) -> Int
typealias StringMap = Map<String, String>

fun main() {

    val unaliased: (Int) -> String = { "The int = $it" }
    println(unaliased(4))

    val aliased: FIntToString = { "The value is $it" }
    println(aliased(5))

    val squared: FIntToInt = { it * it }
    println(squared(6))

    fun dumpMap(map: StringMap) {
        map.forEach { k, v -> println("Key: $k Val: $v") }
    }
    dumpMap(mapOf("a" to "a val"))
}