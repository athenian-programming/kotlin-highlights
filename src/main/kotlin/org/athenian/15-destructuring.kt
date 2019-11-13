package org.athenian

import kotlin.random.Random

// See https://proandroiddev.com/kotlin-destructuring-declarations-46aad0ee5261

fun main() {

    data class Person(val name: String, val age: Int)

    class Location(val latitude: Double, val longitude: Double) {
        operator fun component1() = latitude
        operator fun component2() = longitude
        operator fun component3() = "A string using $latitude and $longitude"
    }

    class RandomVals {
        val randomVal1: Int
            get() = Random.nextInt()

        val randomVal2: Int
            get() = Random.nextInt()
    }

    operator fun RandomVals.component1() = randomVal1
    operator fun RandomVals.component2() = randomVal2
    operator fun RandomVals.component3() = randomVal1 + randomVal2

    // Kotlin data classes include destructuring calls automatically
    val person = Person("Thomas", 40)
    val (name, age) = person
    println("$name is $age years old")

    // Regular classes can add destructuring support by overloading the componentN operators
    val loc = Location(38.2, 110.8)
    val (lat, long, desc) = loc
    println("Lat/Long = $lat/$long $desc")

    // You can add destructuring support to existing classes with extension functions
    val randomVal = RandomVals()
    val (val1, val2, sum) = randomVal
    println("val1, val2, sum = $val1 and $val2 and $sum")

    // You can use destructured assignments in loops as well
    for ((v1, v2, s) in List(5) { RandomVals() })
        println("v1, v2, s = $v1 and $v2 and $s")
}