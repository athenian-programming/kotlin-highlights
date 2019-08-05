package org.athenian

class User(objMap: Map<String, Any?>) {

    // Map Delegate
    val name: String by objMap
    val age: Int     by objMap

    // Lazy Delegate
    val lazyValue: String by lazy {
        println("Computed lazyValue")
        "Hello"
    }
}

fun main() {
    val u = User(
        mapOf(
            "name" to "Bill Smith",
            "age" to 35
        )
    )

    println("${u.name} is ${u.age} years old")

    println("lazyValue = ${u.lazyValue}")
    println("lazyValue = ${u.lazyValue}")
}