package org.athenian

fun main() {

  class User(objMap: Map<String, Any?>) {
    val name: String by objMap
    val address: String by objMap
    val age: Int by objMap
  }

  val userData = mapOf(
    "name" to "Bill Smith",
    "address" to "123 Main",
    "age" to 35
  )

  User(userData)
    .apply {
      println("$name lives at $address and is $age years old")
    }
}