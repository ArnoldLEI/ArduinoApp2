package com.example.arduinoapp2.study

fun main() {
    val x: Int = 100
    val y: Int? = null
    var sum = 0

    if (y == null) {
        val sum = x
        println("total : ${sum}")
    }

    sum = x + (y?:0)  //若y == null 則用0表示
    println("total : ${sum}")

}