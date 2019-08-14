package org.athenian

class Car {
    infix fun drive(dist: Int) {
        println("Driving $dist miles")
    }
}

fun main() {
    val car = Car()

    car.drive(10)

    car drive 20
}
