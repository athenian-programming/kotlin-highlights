package snippets

abstract class Book(val name: String)
class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)

fun <T : Book> findFirstWithoutReification(books: List<Book>, clazz: Class<T>): T =
  (books.firstOrNull { it.javaClass == clazz }
    ?: throw RuntimeException("Not found")) as T

inline fun <reified T : Book> findFirstWithReification(books: List<Book>): T =
  (books.firstOrNull { it is T }
    ?: throw RuntimeException("Not found")) as T

fun main() {
  val books = listOf(Fiction("True Grit"), Fiction("Hawaii"))

  println("Without reification:")
  println(findFirstWithoutReification(books, NonFiction::class.java).name)
  println(findFirstWithoutReification(books, Fiction::class.java).name)

  println("\nWith reification:")
  println(findFirstWithReification<NonFiction>(books).name)
  println(findFirstWithReification<Fiction>(books).name)
}


