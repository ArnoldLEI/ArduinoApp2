package com.example.arduinoapp2.study

fun main(){
    val s = "100"
    val i = 100
    //print(s == i) 不同型別不可直接比較
    println(s == i.toString())

    println(s.equals(i.toString()))

    print(s.toInt() == i)
}