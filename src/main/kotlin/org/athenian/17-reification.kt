package org.athenian

abstract class Book(val name: String)

class Fiction(name: String) : Book(name)

class NonFiction(name: String) : Book(name)

fun <T : Book> findFirstWithoutReification(books: List<Book>, clazz: Class<T>): T =
    (books
        .filter { it.javaClass == clazz }
        .firstOrNull() ?: throw RuntimeException("Not found")) as T

inline fun <reified T : Book> findFirstWithReification(books: List<Book>): T =
    (books
        .filter { it is T }
        .firstOrNull() ?: throw RuntimeException("Not found")) as T

fun main() {
    val books = listOf(Fiction("True Grit"), NonFiction("Kotlin in Action"), Fiction("Hawaii"))

    println("Without reification:")
    println(findFirstWithoutReification(books, NonFiction::class.java).name)
    println(findFirstWithoutReification(books, Fiction::class.java).name)

    println("\nWith reification:")
    println(findFirstWithReification<NonFiction>(books).name)
    println(findFirstWithReification<Fiction>(books).name)
}
