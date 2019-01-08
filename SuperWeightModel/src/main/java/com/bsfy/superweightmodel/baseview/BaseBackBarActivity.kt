package com.bsfy.superweightmodel.baseview

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.MenuItem
import com.bsfy.superutilsmodel.util.weight.StatusBarUtil
import com.bsfy.superweightmodel.R
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.activity_base_back.*

/**
 * ```
 * author: BSFY
 * blog  : com.bsfy.httpmode
 * time  : 2018/11/16
 * desc  : base about back activity
 * ```
 */
abstract class BaseBackBarActivity : BaseActivity() {

    override fun setRootLayout(layoutId: Int) {
        super.setRootLayout(R.layout.activity_base_back)
        Slidr.attach(this)
        if (layoutId > 0) {
            LayoutInflater.from(this).inflate(layoutId, drawerContainerView)
        }
        setSupportActionBar(toolbar)
        //状态栏透明和间距处理
        StatusBarUtil.immersive(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)
        StatusBarUtil.setPaddingSmart(this, findViewById(R.id.blurView))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun setBarTitle(@StringRes resId: Int) {
        supportActionBar?.title = getString(resId)
    }

    fun setBarBackIcon(@DrawableRes resId: Int) {
        toolbar?.setNavigationIcon(resId)
    }

    fun setBarBg(@DrawableRes resId: Int) {
        toolbar?.setBackgroundColor(resId)
    }

}