package org.athenian

// See: https://proandroiddev.com/writing-dsls-in-kotlin-part-1-7f5d2193f277

fun main() {

    data class Address(var street: String? = null, var city: String? = null)

    data class Person(var name: String? = null, var age: Int? = null, var address: Address? = null)

    fun lambdaArg(): Person {

        // Lambda arg
        fun person(block: (Person) -> Unit): Person {
            val p = Person()
            block(p)
            return p
        }

        val p =
            person {
                it.name = "John"
                it.age = 25
            }

        return p
    }

    fun lambdaWithReceiverArg(): Person {

        // Lambda with receiver arg
        fun person(block: Person.() -> Unit): Person {
            val p = Person()
            p.block()
            return p
        }

        val p =
            person {
                name = "Mary"
                age = 26
            }

        return p
    }

    fun embeddedLambdaWithReceiverArg(): Person {

        fun person(block: Person.() -> Unit): Person = Person().apply(block)

        fun Person.address(block: Address.() -> Unit) {
            address = Address().apply(block)
        }

        val p =
            person {
                name = "Tracey"
                age = 21
                address {
                    street = "123 Main"
                    city = "Houston"
                }
            }

        return p
    }

    println("Lambda Arg: ${lambdaArg()}")
    println("Lambda With Receiver Arg: ${lambdaWithReceiverArg()}")
    println("Embedded Lambda With Receiver Arg: ${embeddedLambdaWithReceiverArg()}")
}


