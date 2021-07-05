package com.example.arduinoapp2.study

fun main() {

    val num1 = arrayOf(1,5,"7",9) //隱式
    val num2 = arrayOf<Int>(1,5,7,9) //顯式

    //for loop
    for (i in 0..num1.size-1){
        println(num1[i])
    }

    for (i in num1.indices){
        println(num1[i])
    }

    println(num1.contentToString())


    val num3 = Array( 5, {i -> i * 1})
    println(num3.contentToString())

    val num4 = Array( 5, {i -> i * 1})
    println(num3.contentToString())

    num4.forEach { n -> println("n = $n") }
    num4.forEach { println(it) }




}