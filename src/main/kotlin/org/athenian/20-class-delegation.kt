package org.athenian

interface Programmer {
  fun hack()
}

class JavaProgrammer : Programmer {
  override fun hack() = println("Writing Java code")
}

class CSharpProgrammer : Programmer {
  override fun hack() = println("Writing C# code")
}

class Employee(val programmer: Programmer) : Programmer by programmer {
  fun relax() {
    println("I am relaxing")
  }
}

fun main() {
  val javaPerson = Employee(JavaProgrammer())
  val csharpPerson = Employee(CSharpProgrammer())

  println("Programmer is ${javaPerson.programmer.javaClass.simpleName}")
  javaPerson.hack()
  javaPerson.relax()

  println("Programmer is ${csharpPerson.programmer.javaClass.simpleName}")
  csharpPerson.hack()
  csharpPerson.relax()
}