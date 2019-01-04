package com.bsfy.superweightmodel.feature.bar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2017/05/27
 * desc  : demo about BarUtils
</pre> *
 */
class BarActivity : BaseBackActivity() {

    private var tvAboutStatus: TextView? = null

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_bar
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_bar)

        tvAboutStatus = findViewById(R.id.tv_about_status)
        findViewById<View>(R.id.btn_status_bar).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_color).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_alpha).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_image_view).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_fragment).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_swipe_back).setOnClickListener(this)
        findViewById<View>(R.id.btn_status_bar_drawer).setOnClickListener(this)
        findViewById<View>(R.id.btn_notification_bar).setOnClickListener(this)
        findViewById<View>(R.id.btn_nav_bar).setOnClickListener(this)
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_status_bar) {
            BarStatusActivity.start(this)

        } else if (i == R.id.btn_status_bar_color) {
            BarStatusColorActivity.start(this)

        } else if (i == R.id.btn_status_bar_alpha) {
            BarStatusAlphaActivity.start(this)

        } else if (i == R.id.btn_status_bar_image_view) {
            BarStatusImageViewActivity.start(this)

        } else if (i == R.id.btn_status_bar_fragment) {
            BarStatusFragmentActivity.start(this)

        } else if (i == R.id.btn_status_bar_swipe_back) {
            BarStatusSwipeBackActivity.start(this)

        } else if (i == R.id.btn_status_bar_drawer) {
            BarStatusDrawerActivity.start(this)

        } else if (i == R.id.btn_notification_bar) {
            BarNotificationActivity.start(this)

        } else if (i == R.id.btn_nav_bar) {
            BarNavActivity.start(this)

        }
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, BarActivity::class.java)
            context.startActivity(starter)
        }
    }
}
