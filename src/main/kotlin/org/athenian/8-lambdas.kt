package org.athenian

fun main() {

    // Function reference
    fun returnConst(): Int {
        return 5
    }

    val funcRef: () -> Int = ::returnConst

    println("funcRef: ${funcRef()}")

    // Lambdas without params
    val constant1: () -> Int = fun(): Int { return 4 }
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

    // Higher-order function as return type
    fun receiptText(template: String): (Int) -> String {
        return { amount -> template.replace("%", amount.toString()) }
    }

    println(receiptText("Bill total: $%")(87))

    // Class inheriting from a lambda
    class ReceiptText(val template: String) : (Int) -> String {
        override fun invoke(amount: Int) = template.replace("%", amount.toString())
    }

    val receiptText = ReceiptText("Bill total: $%")
    println(receiptText(55))
    // or
    println(ReceiptText("Bill total: $%")(44))
}

