package com.test.kotlincompose.kotlinbasic

import java.util.stream.Stream

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 函数
 */
class Fun {


    /**
     * 默认用法
     */
    fun double(x: Int): Int {
        return 4 * x
    }

    fun testing() {
        val double = double(2)
        println(double)

    }


    /**
     * 用法一：
     * 函数可以添加默认值，省略参数的时候直接用默认值
     */
    fun read(
        b: Array<Byte>,
        off: Int = 0,
        len: Int = b.size,
    ) { /*……*/
    }


    /**
     * 用法二：
     * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用：
     */
    fun foo(
        bar: Int = 0,
        baz: Int,
    ) { /*……*/
    }

    //foo(baz = 1) // 使用默认值 bar = 0


    /**
     * 用法三：
     * 如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入
     */
    fun foo(
        bar: Int = 0,
        baz: Int = 1,
        qux: () -> Unit,
    ) { /*……*/
    }

    //foo(1) { println("hello") }     // 使用默认值 baz = 1
    //foo(qux = { println("hello") }) // 使用两个默认值 bar = 0 与 baz = 1
    //foo { println("hello") }

    fun fooTest(text: String, it: () -> Unit) {
        text.toString()
        it.invoke()
    }

    private fun fooTest2(it: () -> String) {
        it.toString()
    }

    fun fooTesting() {
        fooTest("hello", it = {
            println("word")
            printHello("")
        })
        fooTest2 {
            {
                3 + 3
            }.toString()
        }
    }


    /**
     * 用法四：
     * 返回 Unit 的函数
     * 如果一个函数不返回任何有用的值，它的返回类型是 Unit。Unit 是一种只有一个值——Unit 的类型。这个值不需要显式返回：
     *
     * Unit 相当于 Java void
     */
    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello $name")
        else
            println("Hi there!")
        // `return Unit` 或者 `return` 是可选的
    }

    fun testPrintHello() {
        printHello("hello")
    }


    /**
     * 用法五：
     * 单表达式函数
     * 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
     *
     * (当返回值类型可由编译器推断时，显式声明返回类型是可选的)
     *     fun float(x: Int) = x * 2
     */
    fun float(x: Int): Int = x * 2


    override fun toString(): String {
        topFun()
        return super.toString()
    }

}

fun topFun(){
    println("hello word")
}
