package org.athenian

fun main() {

  class User(map: Map<String, Any>) {
    val name: String by map
    val address: String by map
    val age: Int by map
  }

  val userData =
    mutableMapOf<String, Any>(
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