package com.bsfy.quickmodel.ui.activity

import android.os.Bundle
import android.view.View
import com.bsfy.quickmodel.R
import com.bsfy.superutilsmodel.util.weight.StatusBarUtil.setPaddingSmart
import com.bsfy.superwebviewmodel.WebViewActivity
import com.bsfy.superweightmodel.baseview.BaseBackBarActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseBackBarActivity() {

    companion object {
        var imageUrl = "https://avatars3.githubusercontent.com/u/27125277?s=400&u=7f33b48d4142cdf649f4a8961e914ecd1d059a80&v=4"
    }

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setPaddingSmart(this, profile)

        iv_image.load(imageUrl, R.mipmap.image_loading)
        tv_login.setOnClickListener({
            WebViewActivity.startActivity(this)
        })
    }

    override fun doBusiness() {
    }

    override fun onWidgetClick(view: View) {

    }


}
