package org.athenian


fun main() {
    class Car {
        infix fun drive(dist: Int) {
            println("Driving $dist miles")
        }
    }

    val car = Car()

    car.drive(10)
    // or
    car drive 20


    infix fun String.concat(other: String) = "$this$other"

    print("Hello" concat "World")
}
