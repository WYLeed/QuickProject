package com.bsfy.superweightmodel.feature.sp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.data.DataManager

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2018/01/08
 * desc  : demo about SPUtils
</pre> *
 */
class SPActivity : BaseBackActivity() {




    private var tvAboutSp: TextView? = null

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_sp
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        tvAboutSp = findViewById(R.id.tv_about_sp)
        findViewById<View>(R.id.btn_sp_put_string).setOnClickListener(this)
        findViewById<View>(R.id.btn_sp_put_int).setOnClickListener(this)
        findViewById<View>(R.id.btn_sp_put_long).setOnClickListener(this)
        findViewById<View>(R.id.btn_sp_put_float).setOnClickListener(this)
        findViewById<View>(R.id.btn_sp_put_boolean).setOnClickListener(this)
        findViewById<View>(R.id.btn_sp_clear).setOnClickListener(this)
    }

    override fun doBusiness() {
        updateAboutSp()
    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_sp_put_string) {
            DataManager.putString()

        } else if (i == R.id.btn_sp_put_int) {
            DataManager.putInt()

        } else if (i == R.id.btn_sp_put_long) {
            DataManager.putLong()

        } else if (i == R.id.btn_sp_put_float) {
            DataManager.putFloat()

        } else if (i == R.id.btn_sp_put_boolean) {
            DataManager.putBoolean()

        } else if (i == R.id.btn_sp_clear) {
            DataManager.clear()

        }
        updateAboutSp()
    }

    private fun updateAboutSp() {
        tvAboutSp!!.text = DataManager.sp2String()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, SPActivity::class.java)
            context.startActivity(starter)
        }
    }
}
