package com.test.kotlincompose.kotlinbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

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
class SetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        foo()

    }

    /**
     * 用法一：
     */
    private val numbers = mutableListOf("one", "two", "three")

    fun foo() {
        numbers.add("seven")
        Collections.swap(numbers, 1, 2)

        println(numbers)
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


    /**
     * 用法三： copy
     * 在特定时刻通过集合复制函数，例如toList()、toMutableList()、toSet() 等等。创建了集合的快照。
     * 结果是创建了一个具有相同元素的新集合 如果在源集合中添加或删除元素，则不会影响副本。副本也可以独立于源集合进行更改
     */
    fun copyList() {
        val toMutableList = numbers.toMutableList()
        numbers.add("five")
        println("source: ${numbers.toList()}")
        println("copy: ${toMutableList.toList()}")
    }


    /**
     * 用法四：
     * 数据过滤，匹配数内部对应的规则，然后 out put
     */
    fun listFilter() {
        val filter = numbers.filter {
            it.length > 2
        }
        println(filter)
    }

    /**
     * 用法五：
     * 映射
     */
    fun listMapping() {

        numbers.map {
            /*do work*/
            //转换、赋值、变化
        }

        numbers.mapIndexed { index, value ->
            {
                /*do work*/
                //转换、赋值、变化
                value + 1
            }
        }

    }

    /**
     * 用法六：
     * 关联
     */
    fun listOf(){
        numbers.associateWith {
            it.uppercase()
        }
    }

}