package com.test.kotlincompose.kotlinbasic

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 集合 - 区间和序列
 */
class SetRanges {


    /**
     * Kotlin 可通过调用 kotlin.ranges 包中的 rangeTo() 函数及其操作符形式的 .. 轻松地创建两个值的区间。 通常，rangeTo() 会辅以 in 或 !in 函数
     * @param i Int
     */
    fun test(i: Int) {
        if (i in 1..4) {  // 等同于 1 <= i && i <= 4
            print(i)
        }

        for (i in 5..6) {
            print(i)
        }

        for(a:Int in 1..5){

        }
    }


    /**
     * 方向迭代
     * @param i Int
     */
    fun rangesRever(i: Int = 10) {
        for (i in 4 downTo 1) {

        }
    }

}