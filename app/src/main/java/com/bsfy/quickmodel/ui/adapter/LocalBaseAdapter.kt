package com.bsfy.quickmodel.ui.adapter

import com.bsfy.superweightmodel.baseview.rv.BaseViewHolder
import com.bsfy.superweightmodel.baseview.rv.adapter.SingleAdapter

/**
 * 作者: Created by wangyu on 2019/1/3.
 */

open class LocalBaseAdapter<M>(list: List<M>, layoutId: Int) : SingleAdapter<M>(list, layoutId) {

    override fun bind(holder: BaseViewHolder, data: M) {

    }
}
