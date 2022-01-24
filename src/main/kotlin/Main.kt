package com.github.va7icana55asin

const val topLevel = "Test String"

fun main(args: Array<String>) {
    printHelloWorld()
    val a = 1 // Constants
    val b = 2
    println("Sum of $a and $b is ${expressionEX(a,b)}")

    println()

    println(topLevel)

    println()

    var value = 5
    var test = "Test"
    val base = BaseClass(test, a, value)
    println("The result for ${base.test} is ${base.result} based on the value ${base.value} and the multiplier ${base.multiplier}")

    val newString = "Another test"
    value = 10
    test = "HAHA"
    val another = NewClass(newString, test, b, value)
    println("Another has the result of ${another.result}")
    println(another.new)

    println()

    val blank = ""
    println(stringFunction(blank))
    println(stringFunction(test))
    println(logicFunction(a,b))
    println(logicFunction(value, a))

    println()

    val list = listOf(1, 2, 3, 4, 5)
    var running = 0
    for (item in list) {
        running += item
        println("The running total is now $running")
    }
    for (index in list.indices) {
        println("Value at $index is ${list[index]}")
    }

    println()

    // While loops are normal so I'll skip that
    println(whenFunc("Wednesday"))

    println()

    if (a in 1..value) {
        println(a)
    }

    for (x in 1..10 step 2) {
        println(x)
    }
    for (x in 9 downTo 2 step 3) {
        println(x)
    }

    println()

    val waterAnimals = listOf("Penguin", "Seal", "Whale")
    val landAnimals = listOf("Tiger", "Elephant", "Lion", "Gorilla")
    val newList = ArrayList<String>()
    newList.addAll(landAnimals)
    newList.addAll(waterAnimals)
    when {
        "Lion" in newList -> println("King of the jungle") // Seems to automatically short circuit after a matching condition is found
        "Penguin" in newList -> println("Slide on my belly")
        "Panther" in newList -> println("Meow")
    }

    val newListClone = ArrayList(newList)
    newListClone
        .filter { waterAnimals.contains(it) }
        .sortedBy { it }
        .map { it.lowercase() }
        .forEach { println(it) }

    println()

    println(checkType(a))
    println(checkType(test))

    println()

    val pojo = PojoClass(test, another = newString)
    println(pojo)
    //listOf and mapOf are read only (mapOf("a" to 1, "b" to 2))
    // map["key"], for((k,v) in map)
}

fun printHelloWorld() {
    println("Hello World!")
}

fun expressionEX(a: Int, b: Int): Int = a+b

fun stringFunction(str: String) = str.ifBlank { "Ummm there is nothing here" }

fun logicFunction(a: Int, b: Int) = if (a > b) "$a is greater than $b" else "$a is less than $b"

fun whenFunc(str: String): Int =
    when (str) {
        "Monday"       -> 1
        "Tuesday"       -> 2
        "Wednesday" -> 3
        "Thursday"     -> 4
        "Friday"          -> 5
        "Saturday"     -> 6
        "Sunday"       -> 7
        else                 -> -1
    }

fun checkType(obj: Any): String? { //Tells the compiler this may return null
    return if (obj is String) {
        obj
    } else {
        null
    }
}

open class BaseClass(var test: String, val multiplier: Int, var value: Int) { // Open makes it inheritable
    var result = multiplier * value
}

class NewClass(var new: String, test: String, multiplier: Int, value: Int): BaseClass(test, multiplier, value)


data class PojoClass(val test: String = "value", val another: String) // Provides getters and setters for non val fields, equals, hashcode, toString, copy, and something called component methods for deconstruction
