package snippets

fun main() {
  var nonNullable: String = "something"
  var nullable: String? = null

  //nonNullable = nullable

  nonNullable = nullable ?: "default value"

  if (nullable != null)
    nonNullable = nullable

  nullable = "else"

  nonNullable = nullable
}




