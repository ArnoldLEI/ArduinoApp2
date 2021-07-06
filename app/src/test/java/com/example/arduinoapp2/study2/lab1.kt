package com.example.arduinoapp2.study2

import kotlin.math.round


class TicketsStock {
    companion object {
        var totalAmount = 20
        fun subAmount(amount: Int) {
            totalAmount = totalAmount - amount
        }
    }
}

class Tickets(var allTickets: Int, var roundTrip: Int) {
    val price: Int = 1000
    val discountRate: Double = 0.9
    var oneWay: Int = 0
    init {
        oneWay = allTickets - roundTrip * 2
    }
    fun total():Int {
        val total = oneWay * price + ( roundTrip * ( price * 2 )) * discountRate
        return  round(total).toInt()
    }
}

fun buyTickets() {
    println("剩餘張數: ${ TicketsStock.totalAmount }")
    println("輸入購買張數: ")
    val allTickets = readLine()!!.toInt()
    if (allTickets  > TicketsStock.totalAmount) {
        println("購買數: ${allTickets} 不可大於剩餘張數: ${TicketsStock.totalAmount}")
        return
    }
    println("請輸入來回票數: ")
    val roundTrip = readLine()!!.toInt()
    if (roundTrip * 2 > allTickets) {
        println("來回組數票數: ${roundTrip * 2} 不可大於總數: ${allTickets}")
        return
    }

    val tickets = Tickets(allTickets, roundTrip)
    println("總票數: ${tickets.allTickets} " +
            "來回票: ${tickets.roundTrip} " +
            "單程票: ${tickets.oneWay} " +
            "總金額: ${tickets.total()} ")

    TicketsStock.subAmount(tickets.allTickets)
    println("剩餘張數: ${ TicketsStock.totalAmount }")
}

fun main() {
    while (true) {
        buyTickets()
        println("是否繼續購買(1:繼續,2:離開)?")
        val exit = readLine()!!.toInt()
        if(exit == 0){
            break
        }
    }
    println("謝謝惠顧，再會 !")
}