package com.bsfy.superweightmodel.feature.snackbar

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.StringRes
import android.text.SpannableStringBuilder
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bsfy.superutilsmodel.util.SnackbarUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superutilsmodel.util.ToastUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/17
 * desc  : demo about SnackbarUtils
</pre> *
 */
class SnackbarActivity : BaseBackActivity() {

    internal lateinit var snackBarRootView: View

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_snackbar
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_snackbar)

        snackBarRootView = findViewById(android.R.id.content)
        findViewById<View>(R.id.btn_short_snackbar).setOnClickListener(this)
        findViewById<View>(R.id.btn_short_snackbar_with_action).setOnClickListener(this)
        findViewById<View>(R.id.btn_long_snackbar).setOnClickListener(this)
        findViewById<View>(R.id.btn_long_snackbar_with_action).setOnClickListener(this)
        findViewById<View>(R.id.btn_indefinite_snackbar).setOnClickListener(this)
        findViewById<View>(R.id.btn_indefinite_snackbar_with_action).setOnClickListener(this)
        findViewById<View>(R.id.btn_add_view).setOnClickListener(this)
        findViewById<View>(R.id.btn_add_view_with_action).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_success).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_warning).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_error).setOnClickListener(this)
        findViewById<View>(R.id.btn_dismiss_snackbar).setOnClickListener(this)
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_short_snackbar) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_short))
                    .setMessageColor(Color.WHITE)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .show()

        } else if (i == R.id.btn_short_snackbar_with_action) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_short))
                    .setMessageColor(Color.WHITE)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .setAction(getString(R.string.snackbar_click), Color.YELLOW) { ToastUtils.showShort(getString(R.string.snackbar_click)) }
                    .show()

        } else if (i == R.id.btn_long_snackbar) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_long))
                    .setMessageColor(Color.WHITE)
                    .setDuration(SnackbarUtils.LENGTH_LONG)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .show()

        } else if (i == R.id.btn_long_snackbar_with_action) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_long))
                    .setMessageColor(Color.WHITE)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .setDuration(SnackbarUtils.LENGTH_LONG)
                    .setAction(getString(R.string.snackbar_click), Color.YELLOW) { ToastUtils.showShort(getString(R.string.snackbar_click)) }
                    .show()

        } else if (i == R.id.btn_indefinite_snackbar) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_indefinite))
                    .setMessageColor(Color.WHITE)
                    .setDuration(SnackbarUtils.LENGTH_INDEFINITE)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .show()

        } else if (i == R.id.btn_indefinite_snackbar_with_action) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_indefinite))
                    .setMessageColor(Color.WHITE)
                    .setDuration(SnackbarUtils.LENGTH_INDEFINITE)
                    .setBgResource(R.drawable.snackbar_custom_bg)
                    .setAction(getString(R.string.snackbar_click), Color.YELLOW) { ToastUtils.showShort(getString(R.string.snackbar_click)) }
                    .show()

        } else if (i == R.id.btn_add_view) {
            val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            SnackbarUtils.with(snackBarRootView)
                    .setBgColor(Color.TRANSPARENT)
                    .setDuration(SnackbarUtils.LENGTH_INDEFINITE)
                    .show()
            SnackbarUtils.addView(R.layout.snackbar_custom, params)

        } else if (i == R.id.btn_add_view_with_action) {
            val params: ViewGroup.LayoutParams
            SnackbarUtils.with(snackBarRootView)
                    .setBgColor(Color.TRANSPARENT)
                    .setDuration(SnackbarUtils.LENGTH_INDEFINITE)
                    .show()
            params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            SnackbarUtils.addView(R.layout.snackbar_custom, params)
            val snackbarView = SnackbarUtils.getView()
            if (snackbarView != null) {
                val tvSnackbarCustom = snackbarView.findViewById<TextView>(R.id.tv_snackbar_custom)
                tvSnackbarCustom.text = "点我可消失"
                snackbarView.setOnClickListener { SnackbarUtils.dismiss() }
            }

        } else if (i == R.id.btn_show_success) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_success))
                    .showSuccess()

        } else if (i == R.id.btn_show_warning) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_warning))
                    .showWarning()

        } else if (i == R.id.btn_show_error) {
            SnackbarUtils.with(snackBarRootView)
                    .setMessage(getMsg(R.string.snackbar_error))
                    .showError()

        } else if (i == R.id.btn_dismiss_snackbar) {
            SnackbarUtils.dismiss()

        }
    }

    private fun getMsg(@StringRes resId: Int): SpannableStringBuilder {
        return SpanUtils()
                .appendImage(R.mipmap.ic_launcher, SpanUtils.ALIGN_CENTER)
                .appendSpace(32)
                .append(getString(resId)).setFontSize(24, true)
                .create()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, SnackbarActivity::class.java)
            context.startActivity(starter)
        }
    }
}
