package com.bsfy.superweightmodel.feature.toast

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superutilsmodel.util.ToastUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.helper.DialogHelper


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/09/29
 * desc  : demo about ToastUtils
</pre> *
 */
class ToastActivity : BaseBackActivity() {

    internal var mHandler = Handler()

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_toast
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_toast)

        findViewById<View>(R.id.btn_show_short_toast).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_long_toast).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_green_font).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_bg_color).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_bg_resource).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_span).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_custom_view).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_middle).setOnClickListener(this)
        findViewById<View>(R.id.btn_cancel_toast).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_toast_dialog).setOnClickListener(this)
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        resetToast()
        val i = view.id
        if (i == R.id.btn_show_short_toast) {
            Thread(Runnable { ToastUtils.showShort(R.string.toast_short) }).start()

        } else if (i == R.id.btn_show_long_toast) {
            //            new Thread(new Runnable() {
            //                @Override
            //                public void run() {
            for (j in 0..9) {
                mHandler.postDelayed({ ToastUtils.showLong(R.string.toast_long) }, (10 * j).toLong())
            }
            //                }
            //            }).start();

        } else if (i == R.id.btn_show_green_font) {
            ToastUtils.setMsgColor(Color.GREEN)
            ToastUtils.showLong(R.string.toast_green_font)

        } else if (i == R.id.btn_show_bg_color) {
            ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.colorAccent))
            ToastUtils.showLong(R.string.toast_bg_color)

        } else if (i == R.id.btn_show_bg_resource) {
            ToastUtils.setBgResource(R.drawable.toast_shape_round_rect)
            ToastUtils.showLong(R.string.toast_custom_bg)

        } else if (i == R.id.btn_show_span) {
            ToastUtils.showLong(SpanUtils()
                    .appendImage(R.mipmap.ic_launcher, SpanUtils.ALIGN_CENTER)
                    .appendSpace(32)
                    .append(getString(R.string.toast_span)).setFontSize(24, true)
                    .create()
            )

        } else if (i == R.id.btn_show_custom_view) {
            Thread(Runnable { CustomToast.showLong(R.string.toast_custom_view) }).start()

        } else if (i == R.id.btn_show_middle) {
            ToastUtils.setGravity(Gravity.CENTER, 0, 0)
            ToastUtils.showLong(R.string.toast_middle)

        } else if (i == R.id.btn_cancel_toast) {
            ToastUtils.cancel()

        } else if (i == R.id.btn_show_toast_dialog) {
            DialogHelper.showToastDialog()

        }
    }

    override fun onDestroy() {
        resetToast()
        super.onDestroy()
    }

    private fun resetToast() {
        ToastUtils.setMsgColor(-0x1000001)
        ToastUtils.setBgColor(-0x1000001)
        ToastUtils.setBgResource(-1)
        ToastUtils.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, resources.getDimensionPixelSize(R.dimen.offset_64))
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, ToastActivity::class.java)
            context.startActivity(starter)
        }
    }
}
