package com.test.kotlincompose.kotlinbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 构造器
 */
class ConstructorHelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Foo("hello").toString()

    }


    class Foo() {

        init {
            println("init print")
        }

        constructor(string: String) : this() {
            println("constructor print:  $string")
        }


        constructor(string: String, num: Int) : this() {
            println("constructor two print:  $string  $num")
        }

    }

}