package com.test.kotlincompose.entity

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/12
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe： 空实体
 */
data class EmptyEntity(val title: String) {

    val text: String
        get() = "数据1"


    val text2: String
        get() = "数据2"


}