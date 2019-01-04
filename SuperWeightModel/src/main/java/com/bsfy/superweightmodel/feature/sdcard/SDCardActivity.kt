package com.bsfy.superweightmodel.feature.sdcard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.util.SDCardUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/09/27
 * desc  : demo about SDCardUtils
</pre> *
 */
class SDCardActivity : BaseBackActivity() {

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_sdcard
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_sdcard)

        val tvAboutSdcard = findViewById<TextView>(R.id.tv_about_sdcard)
        tvAboutSdcard.text = SpanUtils()
                .appendLine("isSDCardEnableByEnvironment: " + SDCardUtils.isSDCardEnableByEnvironment())
                .appendLine("getSDCardPathByEnvironment: " + SDCardUtils.getSDCardPathByEnvironment())
                .appendLine("isSDCardEnable: " + SDCardUtils.isSDCardEnable())
                .appendLine("getSDCardPaths: " + SDCardUtils.getSDCardPaths())
                .appendLine("getInnerSDCardPaths: " + SDCardUtils.getSDCardPaths(true))
                .appendLine("getOuterSDCardPaths: " + SDCardUtils.getSDCardPaths(false))
                .create()
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, SDCardActivity::class.java)
            context.startActivity(starter)
        }
    }
}
