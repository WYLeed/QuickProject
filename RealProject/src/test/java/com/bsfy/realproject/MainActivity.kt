package com.bsfy.realproject

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bsfy.realproject.entity.common.NormalImageEntity
import com.bsfy.realproject.ui.adapter.main.HomeAdapter
import com.bsfy.superweightmodel.baseview.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


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
