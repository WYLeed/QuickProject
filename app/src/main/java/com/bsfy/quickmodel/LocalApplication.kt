package com.bsfy.quickmodel

import android.content.Context
import android.support.multidex.MultiDex

import com.bsfy.superweightmodel.BaseApp

/**
 * 作者: Created by wangyu on 2019/1/2.
 */

class LocalApplication : BaseApp() {


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }
}
