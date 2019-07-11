package org.athenian

// Lambda without params
val constant: () -> Int = { 4 }

// Lambda with params
val adder: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

// Higher-order function
fun twoIntFunc(
    x: Int,
    y: Int,
    block: (Int, Int) -> Int
): Int = block(x, y)

// Usage of it
val double1: (Int) -> Int = { a: Int -> a * 2 }
val double2: (Int) -> Int = { it * 2 }

fun main() {

    println("Constant:")
    println(constant.invoke())
    println(constant())
    println()

    println("adder:")
    println(adder.invoke(4, 5))
    println(adder(4, 5))
    println()

    println("twoIntFunc:")
    println(twoIntFunc(5, 6) { x, y -> x + y })
    println(twoIntFunc(5, 6) { x, y -> x * y })
    println()

    println("double:")
    println(double1(7))
    println(double2(8))
    println()
}

