package com.bsfy.realproject.ui.adapter.main

import com.bsfy.realproject.entity.common.NormalImageEntity
import com.bsfy.realproject.ui.adapter.LocalBaseAdapter
import com.bsfy.superweightmodel.baseview.rv.BaseViewHolder
/**
 * 作者: Created by bsfy on 2019/1/3.
 */

class HomeAdapter(list: List<NormalImageEntity>, layoutId: Int) : LocalBaseAdapter<NormalImageEntity>(list, layoutId) {

    override fun bind(holder: BaseViewHolder, data: NormalImageEntity) {
        super.bind(holder, data)

    }
}
