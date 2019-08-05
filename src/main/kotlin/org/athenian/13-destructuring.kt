package org.athenian

import kotlin.random.Random

// See https://proandroiddev.com/kotlin-destructuring-declarations-46aad0ee5261

data class Person(val name: String, val age: Int)

class Location(val latitude: Double, val longitude: Double) {
    operator fun component1() = latitude
    operator fun component2() = longitude
}

class RandomVals() {
    val randomVal1: Int
        get() = Random.nextInt()

    val randomVal2: Int
        get() = Random.nextInt()
}

operator fun RandomVals.component1() = randomVal1
operator fun RandomVals.component2() = randomVal2

fun main() {

    // Kotlin data classes include destructuring calls
    val person = Person("Thomas", 40)
    val (name, age) = person
    println("$name is $age years old")

    // Regular classes can add destructuring support by overloading the component operators
    val loc = Location(38.2, 110.8)
    val (lat, long) = loc
    println("Lat/Long = $lat/$long")

    // You can add destructuring support to existing classes with extension functions
    val randomVals = RandomVals()
    val (val1, val2) = randomVals
    println("Random vals = $val1 and $val2")

}