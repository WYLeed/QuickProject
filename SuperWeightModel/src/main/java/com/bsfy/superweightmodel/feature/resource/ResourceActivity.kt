package com.bsfy.superweightmodel.feature.resource

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.util.ResourceUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.Config
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2018/05/07
 * desc  :
</pre> *
 */
class ResourceActivity : BaseBackActivity() {

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_resource
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        findViewById<View>(R.id.btn_resource_test_assets).setOnClickListener(this)
        findViewById<View>(R.id.btn_resource_test_raw).setOnClickListener(this)
        val tvAboutResource = findViewById<TextView>(R.id.tv_about_resource)

        tvAboutResource.text = SpanUtils()
                .appendLine("readAssets2String: " + ResourceUtils.readAssets2String("test/test.txt"))
                .appendLine("readAssets2List: " + ResourceUtils.readAssets2List("test/test.txt").toString())
                .append("readRaw2List: " + ResourceUtils.readRaw2List(R.raw.test).toString())
                .create()
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_resource_test_assets) {
            ResourceUtils.copyFileFromAssets("test", Config.CACHE_PATH + "/assets/test")

        } else if (i == R.id.btn_resource_test_raw) {
            ResourceUtils.copyFileFromRaw(R.raw.test, Config.CACHE_PATH + "/raw/test.txt")

        }
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, ResourceActivity::class.java)
            context.startActivity(starter)
        }
    }
}
