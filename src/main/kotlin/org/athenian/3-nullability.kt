package org.athenian

import java.util.*

fun main() {
  // Say good-bye to the dreaded NPE
  // Nullability is built into the type system
  var a: String = "Non-null string var"
  var b: String? = "Nullable string var"

  //a = null
  //a = b

  // Enforced nullability and smart casts
  if (b != null)
    a = b

  // Null propagation
  a = b?.uppercase(Locale.getDefault())?.dropLast(4)?.drop(3) ?: "Found a null value"

  // Trust me, I know what I am doing -- all bets are off for NPE
  a = b!!
}