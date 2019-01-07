package com.bsfy.superwebviewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.bsfy.superutilsmodel.util.AppUtils
import com.bsfy.superwebviewbmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackBarActivity
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 * Created by sunfusheng on 2017/6/18.
 */
class WebViewActivity : BaseBackBarActivity() {


    private val url = "https://github.com/settings/profile"

    override fun onResume() {
        super.onResume()
        webViewWrapper!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        webViewWrapper!!.onPause()
    }

    override fun onDestroy() {
        webViewWrapper!!.onDestroy()
        super.onDestroy()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && webViewWrapper!!.goBack()) {
            true
        } else super.onKeyDown(keyCode, event)
    }

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_web_view
    }

    @SuppressLint("SetTextI18n")
    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        collapsingToolbarLayout!!.title = ""
        setBarTitle(R.string.web_name)
        collapsingToolbarLayout!!.setExpandedTitleColor(resources.getColor(R.color.transparent))//设置还没收缩时状态下字体颜色
        collapsingToolbarLayout!!.setCollapsedTitleTextColor(resources.getColor(R.color.transparent))//设置收缩后Toolbar上字体的颜色
        tv_title!!.text = getString(R.string.app_name) + " (" + AppUtils.getAppName() + ")"
        appBarLayout!!.addOnOffsetChangedListener { appBar, offset -> tv_title!!.alpha = Math.abs(offset * 1f / appBar.totalScrollRange) }
        webViewWrapper!!.loadUrl(url)
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, WebViewActivity::class.java)
            context.startActivity(intent)
        }
    }
}
