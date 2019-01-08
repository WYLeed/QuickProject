package com.bsfy.quickmodel.ui.activity


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.bsfy.quickmodel.R
import com.bsfy.quickmodel.vm.LoginModel
import com.bsfy.superutilsmodel.util.weight.StatusBarUtil.setPaddingSmart
import com.bsfy.superweightmodel.baseview.BaseBackBarActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseBackBarActivity() {

    private var mModel: LoginModel? = null

    companion object {
        var imageUrl = "https://avatars3.githubusercontent.com/u/27125277?s=400&u=7f33b48d4142cdf649f4a8961e914ecd1d059a80&v=4"
    }

    override fun initData(bundle: Bundle?) {
        mModel = ViewModelProviders.of(this).get(LoginModel::class.java)
    }

    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setPaddingSmart(this, profile)
        iv_image.loadCircle(imageUrl, R.mipmap.image_loading)
        tv_login.setOnClickListener(this)

    }

    override fun doBusiness() {
    }

    override fun onWidgetClick(view: View) {
        val viewId = view.id
        if (viewId == tv_login.id) {
            var account=tv_account.text.toString().trim()
            var password=tv_password.text.toString().trim()
            mModel?.login(account,password)
        } else {

        }
    }


}
