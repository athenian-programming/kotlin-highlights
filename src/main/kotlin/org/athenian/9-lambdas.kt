package org.athenian

fun main() {

    // Generic function call
    fun returnFour(): Int {
        return 4
    }

    // Lambdas without params
    val constant1: () -> Int = fun(): Int { return 4 }
    println("constant1(): ${constant1()}")
    println("constant1(): ${constant1.invoke()}")

    val constant2: () -> Int = { 4 }
    println("constant2(): ${constant2()}")

    // Lambdas with params
    val adder1: (Int, Int) -> Int = fun(a: Int, b: Int): Int { return a + b }
    val adder2: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

    println("adder2(4, 5): ${adder2(4, 5)}")

    // Usage of it
    val double1: (Int) -> Int = { a: Int -> a * 2 }
    val double2: (Int) -> Int = { it * 2 }

    println("double2(8): ${double2(8)}")

    // Higher-order function as parameter
    fun twoIntFunc(x: Int,
                   y: Int,
                   block: (Int, Int) -> Int): Int = block(x, y)

    println("twoIntFunc:")
    println(twoIntFunc(5, 6) { x, y -> x + y })
    println(twoIntFunc(5, 6) { x, y -> x * y })

    fun filterInts(nums: List<Int>, filter: (Int) -> Boolean): List<Int> {
        val retval = mutableListOf<Int>()
        for (i in nums)
            if (filter(i))
                retval += i
        return retval
    }

    val evens = { i: Int -> i % 2 == 0 }

    val odds = { i: Int -> i % 2 == 1 }

    val nums = (0..20).toList()

    println("Evens: ${filterInts(nums, evens)}")
    println("Odds: ${filterInts(nums, odds)}")

    println("Above 5: ${filterInts(nums, { i -> i > 5 })}")
    println("Below 10: ${filterInts(nums, { it < 10 })}")


    // Higher-order function as return type
    fun sayHello(): () -> Unit {
        return { println("Hello") }
    }

    // No args
    val greeting = sayHello()

    greeting()
    greeting.invoke()

    // With an arg
    fun sayHelloWithName(): (String) -> Unit {
        return { name: String -> println("Hello $name") }
    }

    val greetingWithName = sayHelloWithName()

    greetingWithName("Jin")
    greetingWithName.invoke("Jin")


    // Derive return lambda from parameter
    fun receiptText(template: String): (Int) -> String {
        return { amount -> template.replace("%", amount.toString()) }
    }

    println(receiptText("Bill total: $%").invoke(87))
    println(receiptText("Bill total: $%")(87))

    // Class inheriting from a lambda
    class ReceiptText(val template: String) : (Int) -> String {
        override fun invoke(amount: Int) = template.replace("%", amount.toString())
    }

    val receiptText = ReceiptText("Bill total: $%")
    println(receiptText(55))
    // or
    println(ReceiptText("Bill total: $%")(44))

    // Function reference
    fun returnConst(): Int {
        return 5
    }

    val funcRef: () -> Int = ::returnConst

    println("funcRef: ${funcRef()}")
}

