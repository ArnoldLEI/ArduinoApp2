package com.example.arduinoapp2.study
import  kotlin.random.Random as r

fun main() {

    //if
    var score = r.nextInt(101)
    val pass = if(score >= 60)"pass" else "fail"
    println("$score $pass")


    //when
    when(score){
        in 90..100 -> println("A")
        in 80..89 -> println("B")
        in 70..79 -> println("C")
        in 60..69 -> println("D")
        else -> println("E")
    }

    val level = when(score){
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "E"
    }
    println(level)

    val level2 = when(score/10){
        10,9 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "E"

    }
    println(level2)


    //for
    for (i in 1..10){
        print("$i ")
    }
    println()
    for (i in 1..10 step 2){
        print("$i ")
    }
    println()
    for (i in 1 until 10){
        print("$i ")
    }
    println()
    for (i in 10 downTo 1){
        print("$i ")
    }
    println()


}