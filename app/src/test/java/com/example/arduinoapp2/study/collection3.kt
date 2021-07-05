package com.example.arduinoapp2.study

data class Person(val name: String, val age: Int)

fun main() {
    val p1 = Person("John", 18)
    val p2 = Person("Mary", 19)
    val p3 = Person("Helen",20)

    val data = listOf<Person>(p1,p2,p3)
    val person = data.maxByOrNull { it.age }
    if (person != null){
        println(person.name)
    }

    var sum = 0
    data.forEach { sum += it.age }
    var avg = sum / data.size
    println(avg)

    var avg2 = data.stream().mapToInt { it.age }.average().asDouble
    println(avg2)

    val stat = data.stream().mapToInt { it.age }.summaryStatistics()
    println(stat)
    println(stat.average)

}