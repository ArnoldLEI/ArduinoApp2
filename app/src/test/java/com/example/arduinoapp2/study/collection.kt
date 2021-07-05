package com.example.arduinoapp2.study

fun main() {
    //集合(高級陣列):set,,list,map
    //Set: 元素不會重複 [1,3,5,7]
    //List: 元素可重複 [1,3,3,7]
    //Map: 每個元素都是 Key/value 的組合 [甲: 100, 乙: 90, 丙: 90]
    //                          Key: [甲, 乙, 丙]  value: [100,90,90]

    val set = setOf<Int>(1,5,2,7,6,3,1)
    println(set)//不可增加元素


    val set2 = mutableSetOf<Int>(1,5,2,7,6,3,1)
    set2.add(9)
    println(set2)
    //最大直
    println(set2.maxOrNull())//最大直
    //有條件最大值
    val score = setOf<Int>(10, 42, 5, 4)
    println(score.maxByOrNull { n -> n % 3 })

    //過濾資料
    val score2 = setOf<Int>(80, 40, 50, 90)
    println(score2.filter { it >= 60 })
    println(score2.filter { it >= 60 }.maxOrNull())

    val names = setOf<String>("Helen", "John", "Jackson", "Anita")
    println(names.maxByOrNull { it .length })



}