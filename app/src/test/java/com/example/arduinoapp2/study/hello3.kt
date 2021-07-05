package com.example.arduinoapp2.study

fun main(){
    val r = 10.5
    //園面積
    val area = Math.pow(r, 2.0) * Math.PI
    println("半徑 : %.1f, 園面積 = %.2f".format(r, area))

    val cube = Math.PI * Math.pow(r, 3.0) * 4 / 3
    println("半徑 : %.1f, 園面積 = %.2f".format(r, cube))

    val bmi = 60 / Math.pow((170.0/100.0), 2.0)
    println("bmi = %.2f".format(bmi))


    val sum1 = 83
    val sum2 = 240

    //x+y = 83
    //2x+4y=240
    //x+2y=120
    //y=37,x=46
    val r = (sum2/2-sum1)
    val c = sum1 - r
    print("雞:%d,兔:%d".format(c,r))
    sum2/2-sum1


}