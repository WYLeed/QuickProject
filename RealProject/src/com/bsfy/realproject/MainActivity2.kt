package com.bsfy.realproject

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bsfy.realproject.entity.common.NormalImageEntity
import com.bsfy.realproject.ui.adapter.main.HomeAdapter
import com.bsfy.superpluginmodel.dynamicload.DLBasePluginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : DLBasePluginActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView() {
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
}