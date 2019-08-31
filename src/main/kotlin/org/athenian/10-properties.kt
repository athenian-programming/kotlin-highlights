package org.athenian

import java.time.LocalDate

// Primary constructor
// Properties as params
class Student(val firstName: String, val lastName: String, private val birthDate: LocalDate) {

    var counter = 0
        private set

    // With block body
    val title: String
        get() {
            return if (age < 16) "Mstr" else "Mr"
        }

    // With expression body
    val fullName
        get() = "$title $firstName $lastName"

    val age
        get() = birthDate.until(LocalDate.now()).years

    var balance = 0
        set(value: Int) {
            counter++
            if (value >= 0)
                field = value
            else
                println("Ignoring negative balnce value $value")
        }
}

fun main() {
    val p = Student("Bill", "Smith", LocalDate.of(1980, 10, 31))

    println("${p.fullName} (aka ${p.firstName}) is ${p.age} years old")

    p.balance = -4
    println("Balance = ${p.balance}")

    p.balance = 4
    println("Balance = ${p.balance}")

    println("Counter = ${p.counter}")
}