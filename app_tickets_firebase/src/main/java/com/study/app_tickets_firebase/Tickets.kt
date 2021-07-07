package com.study.app_tickets_firebase

import kotlin.math.round

class Tickets(var username:String, var allTickets: Int, var roundTrip: Int) {



    var oneWay: Int = 0
    init {
        oneWay = allTickets - roundTrip * 2
    }
    fun total():Int {

        val price = TicketsStock.price
        val discount = TicketsStock.discount

        val total = oneWay * price + ( roundTrip * ( price * 2 )) * discount
        return  round(total).toInt()
    }
}