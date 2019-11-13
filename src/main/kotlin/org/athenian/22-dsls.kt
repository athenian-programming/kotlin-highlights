package org.athenian

import java.text.SimpleDateFormat
import java.util.*

// See:
// https://www.grokkingandroid.com/creating-kotlin-dsls/
// https://www.kotlindevelopment.com/kotlin-dsl/
// https://proandroiddev.com/writing-dsls-in-kotlin-part-2-cd9dcd0c4715

fun main() {

    // Not a very approach
    fun familyExample() {
        class Family {
            val members = mutableListOf<String>()

            fun addMember(name: String) {
                members += name
            }

            operator fun invoke(body: Family.() -> Unit) {
                body()
            }
        }

        val family = Family()

        family {
            addMember("Mom")
            addMember("Dad")
            addMember("Kid")
        }
    }

    data class Address(val street: String, val number: Int, val city: String)

    data class Person(val name: String, val dateOfBirth: Date, var address: Address?)

    fun buildExample(): Person {
        class AddressBuilder {
            var street: String = ""
            var number: Int = 0
            var city: String = ""

            fun build() = Address(street, number, city)
        }

        class PersonBuilder {
            var name: String = ""

            private var dob: Date = Date()
            private var address: Address? = null

            var dateOfBirth: String = ""
                set(value) {
                    dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
                }

            fun address(block: AddressBuilder.() -> Unit) {
                address = AddressBuilder().apply(block).build()
            }

            fun build() = Person(name, dob, address)
        }


        fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()

        return person {
            name = "John"
            dateOfBirth = "1980-12-01"
            address {
                street = "Main Street"
                number = 12
                city = "London"
            }
        }
    }

    println("Build example: ${buildExample()}")
}