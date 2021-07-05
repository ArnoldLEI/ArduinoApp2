package com.example.arduinoapp2.study

fun main() {
    //集合(高級陣列):set,,list,map
    //Set: 元素不會重複 [1,3,5,7]
    //List: 元素可重複 [1,3,3,7]
    //Map: 每個元素都是 Key/value 的組合 [甲: 100, 乙: 90, 丙: 90]
    //                          Key: [甲, 乙, 丙]  value: [100,90,90]

    val set = setOf<Int>(1, 3, 5, 7, 1)
    val list = listOf<Int>(1, 3, 5, 7, 1)
    val map = mapOf<Int, String>(1 to "One", 2 to "Two", 3 to "Three")
    println(set)
    println(list)
    println(map)
    println("---------------")
    // set.iterator()
    val iter = set.iterator()
    println(iter.next())
    println(iter.next())
    set.forEach { println(it) }

    println("list ----------")
    // list 取得指定元素
    println(list[0])
    list.forEach { println(it) }

    println("map ----------")
    // map 取得指定元素
    println(map.get(2))
    println(map[2])
    map.forEach { println(it) }



}