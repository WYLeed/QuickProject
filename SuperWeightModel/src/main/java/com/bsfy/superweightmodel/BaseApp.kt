package com.bsfy.superweightmodel

import android.support.v7.app.AppCompatDelegate
import com.bsfy.superutilsmodel.util.Utils
import com.bsfy.superutilsmodel.util.weight.DynamicTimeFormat
import com.bsfy.superweightmodel.baseview.BaseApplication
import com.github.moduth.blockcanary.BlockCanary
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.squareup.leakcanary.LeakCanary


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

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)

        BlockCanary.install(this, AppBlockCanaryContext()).start()

    }

    companion object {
        public var instance: BaseApp? = null
        init {
            //启用矢量图兼容
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
            //设置全局默认配置（优先级最低，会被其他设置覆盖）
            SmartRefreshLayout.setDefaultRefreshInitializer { context, layout ->

                //全局设置（优先级最低）
                layout.setEnableAutoLoadMore(true)
                layout.setEnableOverScrollDrag(false)
                layout.setEnableOverScrollBounce(true)
                layout.setEnableLoadMoreWhenContentNotFull(true)
                layout.setEnableScrollContentWhenRefreshed(true)

            }
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
                //全局设置主题颜色（优先级第二低，可以覆盖 DefaultRefreshInitializer 的配置，与下面的ClassicsHeader绑定）
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)
                ClassicsHeader(context).setTimeFormat(DynamicTimeFormat("更新于 %s"))
            }
        }
    }
}


