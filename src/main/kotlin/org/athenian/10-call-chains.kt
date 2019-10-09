package org.athenian

fun nonLambdaCalculation(inputList: List<Int>): Int {
    var result = 0
    for (input in inputList) {
        if (input == -1) break
        if (input % 2 == 0) {
            result += input * input
        }
    }
    return result
}

fun lambdaCalculation(inputList: List<Int>): Int =
    inputList
        .takeWhile { it != -1 }
        .filter { it % 2 == 0 }
        .map { it * it }
        .sum()

fun main() {
    val intVals = listOf(0, 2, 5, 6, 4, 7, 8, -1, 12, 14)

    println(nonLambdaCalculation(intVals))
    println(lambdaCalculation(intVals))

    (1..10)
        .onEach { println("Working on $it") }
        .take(5)
        .map { it * 5 }
        .mapIndexed { i, v -> "A string using $v at index $i" }
        .onEach { println("Looking at [$it]") }

    val map = mutableMapOf<String, Int>("A" to 10, "B" to 11, "C" to 12)

    println("Keys: ${map.keys}")
    println("Values: ${map.values}")

    println("Filter: ${map.filter { entry -> entry.key != "B" }}")

}