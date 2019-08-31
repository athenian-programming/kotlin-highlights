package org.athenian

abstract class Book(val name: String)

class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)

inline fun <reified T : Book> findFirst(books: List<Book>): T =
    (books
        .filter { it is T }
        .firstOrNull() ?: throw RuntimeException("Not found")) as T

fun main() {
    val books = listOf(Fiction("True Grit"), NonFiction("Kotlin in Action"), Fiction("Hawaii"))

    println(findFirst<NonFiction>(books).name)
    println(findFirst<Fiction>(books).name)
}
