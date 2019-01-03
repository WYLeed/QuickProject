package com.BSFY.utilcode.pkg.feature.vibrate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bsfy.superweightmodel.base.BaseBackActivity
import com.bsfy.superutilsmodel.util.VibrateUtils
import com.bsfy.superweightmodel.R
import kotlinx.android.synthetic.main.activity_vibrate.*

/**
 * ```
 * author: BSFY
 * blog  : http://BSFY.com
 * time  : 2018/12/29
 * desc  : demo about VibrateUtils
 * ```
 */
class VibrateActivity : BaseBackActivity() {

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, VibrateActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_vibrate
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_vibrate)
        vibrate1000msBtn.setOnClickListener { VibrateUtils.vibrate(1000) }
        vibrateCustomBtn.setOnClickListener {
            VibrateUtils.vibrate(longArrayOf(1000, 1000, 2000, 2000, 1000), 1)
        }
        vibrateCancelBtn.setOnClickListener { VibrateUtils.cancel() }
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }

    override fun onDestroy() {
        super.onDestroy()
        VibrateUtils.cancel()
    }
}
