package com.test.kotlincompose.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.test.kotlincompose.R
import com.test.kotlincompose.entity.HomeEntity

class HomeAdapter : BaseQuickAdapter<HomeEntity, BaseViewHolder>(R.layout.item_home) {

    override fun convert(holder: BaseViewHolder, item: HomeEntity) {

        holder.setText(R.id.tv_text, item.title)
    }


}
