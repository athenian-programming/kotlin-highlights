package org.athenian

import kotlin.random.Random

fun main() {

  val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')

  fun nonLambdaRandomId(length: Int = 10): String {
    val strbuf = StringBuffer()
    repeat(length) {
      strbuf.append(charPool[Random.nextInt(0, charPool.size)])
    }
    return strbuf.toString()
  }

  fun lambdaRandomId(length: Int = 10): String =
    (1..length)
      .map { Random.nextInt(0, charPool.size) }
      .map { i -> charPool[i] }
      .joinToString("")

  println(nonLambdaRandomId(20))
  println(lambdaRandomId(20))
}