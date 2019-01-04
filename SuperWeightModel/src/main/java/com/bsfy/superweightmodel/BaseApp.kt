package com.bsfy.superweightmodel

import com.bsfy.superutilsmodel.util.Utils
import com.bsfy.superweightmodel.baseview.BaseApplication


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/12
 * desc  : app about utils
</pre> *
 */
open class BaseApp : BaseApplication() {

    override fun onCreate() {
        Utils.init(this)
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: BaseApp? = null
    }
}


