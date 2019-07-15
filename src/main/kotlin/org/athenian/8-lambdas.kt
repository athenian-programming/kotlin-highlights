package org.athenian

// Lambda without params
val constant: () -> Int = { 4 }

// Lambda with params
val adder: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

// Usage of it
val double1: (Int) -> Int = { a: Int -> a * 2 }
val double2: (Int) -> Int = { it * 2 }

// Higher-order function
fun twoIntFunc(
    x: Int,
    y: Int,
    block: (Int, Int) -> Int
): Int = block(x, y)


fun main() {
    println("constant(): ${constant()}")

    println("adder(4, 5): ${adder(4, 5)}")

    println("double2(8): ${double2(8)}")

    println("twoIntFunc:")
    println(twoIntFunc(5, 6) { x, y -> x + y })
    println(twoIntFunc(5, 6) { x, y -> x * y })
}

