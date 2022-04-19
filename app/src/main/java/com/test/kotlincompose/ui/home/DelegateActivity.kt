package com.test.kotlincompose.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.test.kotlincompose.databinding.ActivityDelegateBinding
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/12
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 委托代理类
 *
 * 有一些常见的属性类型，虽然我们可以在每次需要的时候手动实现它们， 但是如果能够为大家把他们只实现一次并放入一个库会更好。例如包括：
 * 延迟属性（lazy properties）: 其值只在首次访问时计算；
 * 可观察属性（observable properties）: 监听器会收到有关此属性变更的通知；
 * 把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。
 *
 * @see https://www.kotlincn.net/docs/reference/delegated-properties.html
 *
 */
class DelegateActivity : AppCompatActivity() {


    private var _binding: ActivityDelegateBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDelegateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvContent.text = "委托代理"

    }


    /**
     * 委托代理函数
     *
     * 拓展委托代理工厂类，例如初始化、异步控制、等
     */
    fun toDelegateFun(view: View) {

//        val example = Example()
//        example.p = "Hello"
//        test2Delegate = "hello"

        val user = User()
        user.test3Delegate = "委托代理观察value"
        binding.tvContent.text = user.test3Delegate

    }


    class Example {
        var p: String by Delegate()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }


    /**
     * 委托代理模型
     */
    private val testDelegate by lazy { this }


    /**
     * 委托代理测试类
     */
    private var test2Delegate: Any by NotNullDelegate()

    class NotNullDelegate<T> : ReadWriteProperty<Any?, T> {

        private var value: T? = null

        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return value ?: throw IllegalArgumentException("not initialized")
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value =
                if (this.value == null) value else throw IllegalStateException("application already initialized")
        }

    }



    /**
     * 委托代理 可观察属性 Observable
     *
     * 此模式类似于观察者模式，可用来监听数据改变，应用场景例如同意隐私政策初始化状态、回调通知等
     *
     *
     * 如果你想截获赋值并“否决”它们，那么使用 vetoable() 取代 observable()。 在属性被赋新值生效之前会调用传递给 vetoable 的处理程序。
     *
     */
    class User {
        var test3Delegate: String by Delegates.observable("<no name>") {
                prop, old, new ->
            println("$old -> $new")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

