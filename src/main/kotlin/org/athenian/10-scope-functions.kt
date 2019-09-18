package org.athenian

fun main() {
    class Person(val name: String, var level: Int) {
        fun increaseLevel() {
            level++
        }

        fun desc(): String {
            return "$name is the name and $level is the level"
        }
    }

    // Without a scope function
    val p1 = Person("Mary", 8)
    println("${p1.name} is a level ${p1.level}")
    p1.increaseLevel()
    println("${p1.name} is now a level ${p1.level}\n")

    // With apply
    val p2 =
        Person("Bill", 7)
            .apply {
                println("$name is a level $level")
                increaseLevel()
                println("$name is now a level $level\n")
            }

    // With also
    val p3 =
        Person("Frank", 12)
            .also {
                println("${it.name} is a level ${it.level}")
                it.increaseLevel()
                println("${it.name} is now a level ${it.level}\n")
            }

    // With run
    val p4_desc =
        Person("Theresa", 14)
            .run {
                println("$name is a level $level")
                increaseLevel()
                println("$name is now a level $level")
                desc()
            }
    println("$p4_desc\n")

    // With let
    val p5_desc =
        Person("Ron", 4)
            .let {
                println("${it.name} is a level ${it.level}")
                it.increaseLevel()
                println("${it.name} is now a level ${it.level}")
                it.desc()
            }
    println("$p5_desc\n")
}
