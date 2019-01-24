package com.bsfy.quickmodel.ui.adapter

import com.bsfy.superweightmodel.baseview.rv.BaseViewHolder
import com.bsfy.superweightmodel.baseview.rv.adapter.SingleAdapter

/**
 * 作者: Created by bsfy on 2019/1/3.
 */

open class XBaseAdapter<M>(list: List<M>, layoutId: Int) : SingleAdapter<M>(list, layoutId) {

    override fun bind(holder: BaseViewHolder, data: M) {

    }
}