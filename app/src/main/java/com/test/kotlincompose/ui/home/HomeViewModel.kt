package com.test.kotlincompose.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.kotlincompose.entity.HomeEntity
import com.test.kotlincompose.kotlinbasic.ConstructorHelloActivity
import com.test.kotlincompose.kotlinbasic.SetActivity

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<List<HomeEntity>>().apply {
        value = homeItemList
    }
    val recyclerviewData: LiveData<List<HomeEntity>> = _title



    private val homeItemList: ArrayList<HomeEntity>
        get() = arrayListOf(
            HomeEntity("内联函数", InlineFunActivity::class.java, "内联函数表达式"),
            HomeEntity("委托代理", DelegateActivity::class.java, "委托代理类"),
            HomeEntity("构造器函数测试", ConstructorHelloActivity::class.java, "构造器函数测试类"),
            HomeEntity("集合测试", SetActivity::class.java, "集合函数测试类"),
        )

}