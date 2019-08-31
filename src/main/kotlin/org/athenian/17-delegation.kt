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
    val javaGuy = Employee(JavaProgrammer())
    val csharpGuy = Employee(CSharpProgrammer())

    println("Programmer is ${javaGuy.programmer.javaClass.simpleName}")
    javaGuy.hack()
    javaGuy.relax()

    println("Programmer is ${csharpGuy.programmer.javaClass.simpleName}")
    csharpGuy.hack()
    csharpGuy.relax()
}