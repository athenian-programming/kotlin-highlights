package org.athenian

import java.util.*

fun main() {
  val words = "The quick brown fox jumps over the lazy dog".split(" ")

  words.count()
  words.get(2)
  words[4]
  words.contains("quick")

  val any = words.any { it.length > 4 }
  val all = words.all { it.length > 4 }
  val none = words.none { it.length == 1 }

  val first = words.first { it.length == 3 }
  val last = words.last { it.length == 3 }

  val count = words.count { it.contains("o") }

  val longWords = words.filter { it.length > 3 }

  val convertedWords = words.map { it.uppercase(Locale.getDefault()) }

  val takeWhile = words.takeWhile { it != "over" }

  val partitionedWords = words.partition { it.length > 3 }

  //words.forEach { println(it.length) }

  val wordLengths = words.map { it.length }

  val germanWords = "Der schnelle braune Fuchs springt über den faulen Hund".split(" ")

  val matchedWords = words zip germanWords

  val wordLengthAssociation = words.associateWith { it.length }

  val wordsFlattened = listOf(words, germanWords).flatten()

  println(wordsFlattened)
}

