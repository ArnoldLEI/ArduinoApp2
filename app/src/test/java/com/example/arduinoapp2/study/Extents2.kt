package com.example.arduinoapp2.study

abstract class Tea(val name:String, val price:Int){
    fun printTeaInfo(){
        println("$name $$price")
    }
    abstract fun printElementsOfTea()

}

class RedTea(name:String, price:Int): Tea(name, price){
    override fun printElementsOfTea() {
        println("RedTea + Water")
    }
}

class MilkTea(name:String, price:Int): Tea(name, price){
    override fun printElementsOfTea() {
        println("RedTea + Milk + Water")
    }
}

fun main() {
    val redTea = RedTea("錫蘭紅茶", 20)
    val milkTea = MilkTea("厚奶茶", 35)
    val milkGeenTea = MilkTea("奶綠茶", 30)
    val tea = listOf<Tea>(redTea, milkTea, milkGeenTea)
    tea.forEach { it.printElementsOfTea() }
    tea.forEach { it.printTeaInfo() }
    tea.forEach { println(it.name) }
    tea.forEach { println(it.price) }

    var sum = 0
    tea.forEach { sum += it.price }
    var avg = sum / tea.size
    println(avg)

    var avg2 = tea.stream().mapToInt { it.price }.average().asDouble
    println(avg2)

    val stat = tea.stream().mapToInt { it.price }.summaryStatistics()
    println(stat)
    println(stat.average)
}




