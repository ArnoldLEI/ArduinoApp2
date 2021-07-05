package com.example.arduinoapp2.study
import kotlin.random.Random as r

fun main() {

    val ans = r.nextInt(1,11)
    val max = 5
    var up =10
    var down = 1
    var getans = 0

    for (i in 1..max){
        println("第 $i/$max 次: 請輸入數字($down ~ $up): ")
        val guess = readLine()!!.toInt()
        println("guess: $guess")
        if (guess == ans){
            println("Bingo!")
            getans = 1
            break
        }
        if(guess < ans){
            println("請猜大一點")
            down = guess

        }
        else{
            println("請猜小一點")
            up = guess

        }

    }
    if (getans == 0){
        println("Game Over")
    }


}