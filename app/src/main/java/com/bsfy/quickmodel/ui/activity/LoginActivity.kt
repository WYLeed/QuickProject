package com.bsfy.quickmodel.ui.activity

import android.os.Bundle
import android.view.View
import com.bsfy.quickmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackBarActivity

class LoginActivity : BaseBackBarActivity() {

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setBarTitle(R.string.login_title)
    }

    override fun doBusiness() {
    }

    override fun onWidgetClick(view: View) {

    }


}
