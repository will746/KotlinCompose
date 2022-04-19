package com.test.kotlincompose.entity

import android.app.Activity

/**
 * @Author： WangTao
 * @CreatedOn： 2022/04/19
 * @Version： v1.0
 * @Copyright： Copyright (c) 2022. All Rights Reserved.
 * - - - - - - - - - - - - - - - - - - - -
 * @Describe：
 */
data class HomeEntity(
    val title: String = "",
    val activity: Class<*>? = null,
    val content: String = ""
)