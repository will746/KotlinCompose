package com.test.kotlincompose.kotlinbasic

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe：数据类
 *
 * @https://www.kotlincn.net/docs/reference/collections-overview.html
 *
 * https://pl.kotl.in/6pkFkQz6r 在线编辑
 */
class Set {


    /**
     * 用法一
     */
    val numbers = mutableListOf("one", "two", "three")

    fun foo(){
        numbers.add("seven")
    }

    /**
     * 用法二，键值形式
     *
     * 不推荐使用，损耗性能
     */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    val numbersMapTemp = mutableMapOf<String, String>().apply {
        this["one"] = "1"
        this["two"] = "2"
        this["three"] = "3"
    }

    val empty = emptyList<String>();
    val emptySet = emptySet<String>()
    val emptyMap = emptyMap<String, String>()

}