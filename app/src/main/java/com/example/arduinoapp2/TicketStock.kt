package com.example.arduinoapp2

class TicketsStock {
    companion object {
        var totalAmount = 30
        fun subAmount(amount: Int) {
            totalAmount = totalAmount - amount
        }
    }
}