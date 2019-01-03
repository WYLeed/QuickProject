package com.bsfy.quickmodel

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bsfy.quickmodel.entity.common.NormalImageEntity
import com.bsfy.quickmodel.ui.adapter.main.HomeAdapter
import com.bsfy.superweightmodel.base.BaseActivity
import com.bsfy.superweightmodel.feature.image.ImageActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {


    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        val list: MutableList<NormalImageEntity> = ArrayList()
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        list.add(NormalImageEntity("sss"))
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = HomeAdapter(list, R.layout.adapter_main)


    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }
}
