package org.athenian

fun main() {

  class User(objMap: Map<String, Any?>) {
    val name: String by objMap
    val address: String by objMap
    val age: Int by objMap
  }

  val userData: MutableMap<String, Any> =
    mutableMapOf(
      "name" to "Bill Smith",
      "address" to "123 Main",
      "age" to 35
    )

  User(userData)
    .apply {
      println("$name lives at $address and is $age years old")
      userData["name"] = "Lisa Johnson"
      userData["address"] = "456 Diablo Rd"
      userData["age"] = 15
      println("$name lives at $address and is $age years old")
    }
}