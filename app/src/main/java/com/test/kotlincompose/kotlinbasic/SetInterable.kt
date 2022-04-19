package com.test.kotlincompose.kotlinbasic

import java.util.*

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 集合 - 迭代器
 */
class SetInterable {


    private val num = listOf("a", "b", "c", "d")

    /**
     * 普通迭代器用法
     */
    fun getIterator() {
        val numbers = listOf("one", "two", "three", "four")
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }
    }

    /**
     * 循环
     */
    fun getFor() {
        for (item in num) {
            println(item)
            num.associateWith {
                it.uppercase()
            }
            println(item)
        }
    }


    /**
     * 可变迭代器
     */
    fun transformation(){
        val numbers = mutableListOf("one", "two", "three", "four")
        val mutableIterator = numbers.iterator()

        mutableIterator.next()
        mutableIterator.remove()
        println("After removal: $numbers")
    }



    /**
     * 插入数据
     */
    fun insert(){
        val numbers = mutableListOf("one", "four", "four")
        val mutableListIterator = numbers.listIterator()

        mutableListIterator.next()
        mutableListIterator.add("two")
        mutableListIterator.next()
        mutableListIterator.set("three")
        println(numbers)

    }


}