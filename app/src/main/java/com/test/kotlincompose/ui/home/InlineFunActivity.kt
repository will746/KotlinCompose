package com.test.kotlincompose.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.test.kotlincompose.databinding.ActivityInlineBinding
import com.test.kotlincompose.entity.EmptyEntity
import java.lang.StringBuilder

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/12
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 内联函数
 */
class InlineFunActivity : AppCompatActivity()  {

    private lateinit var emptyEntity: EmptyEntity

    private var _binding: ActivityInlineBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityInlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emptyEntity = EmptyEntity("Inline对象")

        binding.tvContent.text = emptyEntity.toString()

    }

    /**
     * 内联函数之 let
     *
     * 场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。
     * 场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用
     *
     */
    fun toLetFun(view: View) {
        val emptyEntity = EmptyEntity("1")

        emptyEntity.let {
            val content = "${it.text}  ${it.text2}"
            println(content)
            binding.tvContent.text = content
        }

    }


    /**
     * 内联函数之 with
     *
     * 1、返回值为函数块的最后一行或指定return表达式。
     */
    fun toWithFun(view: View) {

        val data = with(emptyEntity) {
            val content = "$text  $text2"
            println(content)
            "返回最后一行代码"
        }
        binding.tvContent.text = data.toString()
    }


    /**
     * 内联函数之 run
     *
     * 1、let、with 结合体, 判断空的基础上，返回最后一行代码块。
     */
    fun toRunFun(view: View) {

        val data = emptyEntity.run {
            val content = "$text  $text2"
            println(content)
            "let with 结合返回"
        }
        binding.tvContent.text = data
    }

    /**
     * 内联函数之 alse
     *
     *1、also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用。
     */
    fun toAlsoFun(view: View) {

        val data = emptyEntity.also {
            val content = "$it.text  $it.text2"
            println(content)
        }.text2
        binding.tvContent.text = data

    }

    /**
     * 内联函数之 apply
     *
     * 1、适用于run函数的任何场景，一般用于初始化一个对象实例的时候，操作对象属性，并最终返回这个对象。
     * 2、动态inflate出一个XML的View的时候需要给View绑定数据也会用到。
     * 3、一般可用于多个扩展函数链式调用。
     * 4、数据model多层级包裹判空处理的问题。
     */
    fun toApplyFun(view: View) {

        val data = emptyEntity.apply {
            val content = "$text  $text2"
            println(content)
        }.text2
        binding.tvContent.text = data
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}