package snippets

fun main() {

  class User(map: Map<String, Any>) {
    val name: String by map
    val age: Int by map
  }

  val userData =
    mutableMapOf<String, Any>("name" to "Bill Smith", "age" to 35)

  User(userData)
    .apply {
      println("$name is $age years old")
      userData["name"] = "Lisa Johnson"
      userData["age"] = 25
      println("$name is $age years old")
    }
}



