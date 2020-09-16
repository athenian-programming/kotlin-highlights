package snippets

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
  // ...
}

fun main() {
  reformat(str = "a str")
  reformat("a str", upperCaseFirstLetter = false, normalizeCase = true)
}




