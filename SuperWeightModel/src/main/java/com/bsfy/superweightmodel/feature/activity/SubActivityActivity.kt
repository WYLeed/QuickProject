package com.bsfy.superweightmodel.feature.activity


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import java.util.*

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/13
 * desc  : demo about ActivityUtils
</pre> *
 */
class SubActivityActivity : BaseBackActivity() {

    internal var random = Random()

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }
        return R.layout.activity_activity_sub
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        (contentView.parent as View).setBackgroundColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)))
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        ActivityCompat.finishAfterTransition(this)
//    }
}
