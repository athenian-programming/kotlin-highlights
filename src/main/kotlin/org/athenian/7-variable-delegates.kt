package org.athenian

import java.time.LocalDateTime
import kotlin.reflect.KProperty


class User(objMap: Map<String, Any?>) {

    class TimestampedString(var content: String = "") {
        operator fun getValue(thisRef: Any?, property: KProperty<*>) = content

        operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
            content = "${LocalDateTime.now()}: $value"
        }
    }

    // Map Delegate
    val name: String by objMap
    val age: Int by objMap

    // Lazy Delegate
    val lazyValue: String by lazy {
        println("Computed lazyValue")
        "Hello"
    }

    // Object Delegate
    var desc: String by TimestampedString()
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

    u.desc = "A new value"
    println("Desc = ${u.desc}")
    u.desc = "A second new value"
    println("Desc = ${u.desc}")
}