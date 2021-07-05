package com.example.arduinoapp2.study
import kotlin.random.Random

fun main() {
    val stars = Array(4) { _ -> Random.nextInt(10)}
    println(stars.contentToString())
}