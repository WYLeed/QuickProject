package com.bsfy.superweightmodel.feature.activity


import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bsfy.superutilsmodel.util.ActivityUtils
import com.bsfy.superutilsmodel.util.LogUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.Config
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.feature.CoreUtilActivity
import java.util.*

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/13
 * desc  : demo about ActivityUtils
</pre> *
 */
class ActivityActivity : BaseBackActivity() {

    internal lateinit var viewSharedElement: ImageView
    internal var random = Random()
    private var bitmap: Bitmap? = null

    private val intents = arrayOfNulls<Intent>(2)

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }
        return R.layout.activity_activity
    }


    override fun initView(savedInstanceState: Bundle?, contentView: View) {

        setTitle(R.string.demo_activity)

        viewSharedElement = findViewById(R.id.view_shared_element)
        findViewById<View>(R.id.btn_clz).setOnClickListener(this)
        findViewById<View>(R.id.btn_clz_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_clz_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_clz).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_clz_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_clz_shared_element).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_clz_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_pkg_cls).setOnClickListener(this)
        findViewById<View>(R.id.btn_pkg_cls_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_pkg_cls_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_pkg_cls).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_pkg_cls_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_pkg_cls_shared_element).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_pkg_cls_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_intent).setOnClickListener(this)
        findViewById<View>(R.id.btn_intent_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_intent_shared_element).setOnClickListener(this)
        findViewById<View>(R.id.btn_intent_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_intents).setOnClickListener(this)
        findViewById<View>(R.id.btn_intents_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_intents_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_intents).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_intents_opt).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_intents_anim).setOnClickListener(this)
        findViewById<View>(R.id.btn_act_clz_shared_element).setOnClickListener(this)
        findViewById<View>(R.id.btn_start_home_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_finish_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_finish_to_activity).setOnClickListener(this)
        findViewById<View>(R.id.btn_finish_all_activities).setOnClickListener(this)
        val tvAboutActivity = findViewById<TextView>(R.id.tv_about_activity)
        tvAboutActivity.text = SpanUtils()
                .appendLine("isActivityExists: " + ActivityUtils.isActivityExists(Config.PKG, SubActivityActivity::class.java.name))
                .appendLine("getLauncherActivity: " + ActivityUtils.getLauncherActivity(Config.PKG))
                .appendLine("getTopActivity: " + ActivityUtils.getTopActivity())
                .appendLine("isActivityExistsInStack: " + ActivityUtils.isActivityExistsInStack(CoreUtilActivity::class.java))
                .append("getActivityIcon: ")
                .appendImage(ActivityUtils.getActivityIcon(this), SpanUtils.ALIGN_CENTER)
                .appendLine()
                .append("getActivityLogo: ")
                .appendImage(ActivityUtils.getActivityLogo(this), SpanUtils.ALIGN_CENTER)
                .create()
        bitmap = (viewSharedElement.drawable as BitmapDrawable).bitmap

        intent = Intent(this, SubActivityActivity::class.java)
        intents[0] = intent
        intents[1] = Intent(this, SubActivityActivity::class.java)
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_clz) {
            ActivityUtils.startActivity(SubActivityActivity::class.java)

        } else if (i == R.id.btn_clz_opt) {
            ActivityUtils.startActivity(SubActivityActivity::class.java,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_clz_anim) {
            ActivityUtils.startActivity(SubActivityActivity::class.java,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_act_clz) {
            ActivityUtils.startActivity(this,
                    SubActivityActivity::class.java)

        } else if (i == R.id.btn_act_clz_opt) {
            ActivityUtils.startActivity(this,
                    SubActivityActivity::class.java,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_act_clz_shared_element) {
            ActivityUtils.startActivity(this,
                    SubActivityActivity::class.java,
                    viewSharedElement)

        } else if (i == R.id.btn_act_clz_anim) {
            ActivityUtils.startActivity(this,
                    SubActivityActivity::class.java,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_pkg_cls) {
            ActivityUtils.startActivity(this.packageName,
                    SubActivityActivity::class.java.name)

        } else if (i == R.id.btn_pkg_cls_opt) {
            ActivityUtils.startActivity(this.packageName,
                    SubActivityActivity::class.java.name,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_pkg_cls_anim) {
            ActivityUtils.startActivity(this.packageName,
                    SubActivityActivity::class.java.name,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_act_pkg_cls) {
            ActivityUtils.startActivity(this,
                    this.packageName,
                    SubActivityActivity::class.java.name)

        } else if (i == R.id.btn_act_pkg_cls_opt) {
            ActivityUtils.startActivity(this,
                    this.packageName,
                    SubActivityActivity::class.java.name,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_act_pkg_cls_shared_element) {
            ActivityUtils.startActivity(this,
                    this.packageName,
                    SubActivityActivity::class.java.name,
                    viewSharedElement)

        } else if (i == R.id.btn_act_pkg_cls_anim) {
            ActivityUtils.startActivity(this,
                    this.packageName,
                    SubActivityActivity::class.java.name,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_intent) {
            ActivityUtils.startActivity(this,
                    intent!!)

        } else if (i == R.id.btn_intent_opt) {
            ActivityUtils.startActivity(this,
                    intent!!,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_intent_shared_element) {
            ActivityUtils.startActivity(this,
                    intent!!,
                    viewSharedElement)

        } else if (i == R.id.btn_intent_anim) {
            ActivityUtils.startActivity(this,
                    intent!!,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_intents) {
            ActivityUtils.startActivities(intents)

        } else if (i == R.id.btn_intents_opt) {
            ActivityUtils.startActivities(intents,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_intents_anim) {
            ActivityUtils.startActivities(intents,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_act_intents) {
            ActivityUtils.startActivities(this,
                    intents,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_act_intents_opt) {
            ActivityUtils.startActivities(this,
                    intents,
                    getOption(random.nextInt(5)))

        } else if (i == R.id.btn_act_intents_anim) {
            ActivityUtils.startActivities(this,
                    intents,
                    R.anim.fade_in_1000, R.anim.fade_out_1000)

        } else if (i == R.id.btn_start_home_activity) {
            ActivityUtils.startHomeActivity()

        } else if (i == R.id.btn_finish_activity) {
            ActivityUtils.finishActivity(CoreUtilActivity::class.java)

        } else if (i == R.id.btn_finish_to_activity) {
            ActivityUtils.finishToActivity(CoreUtilActivity::class.java, false, true)

        } else if (i == R.id.btn_finish_all_activities) {
            ActivityUtils.finishAllActivities()

        }
    }

    private fun getOption(type: Int): Bundle? {
        LogUtils.d(type)
        when (type) {
            0 -> return ActivityOptionsCompat.makeCustomAnimation(this,
                    R.anim.slide_in_right_1000,
                    R.anim.slide_out_left_1000)
                    .toBundle()
            1 -> return ActivityOptionsCompat.makeScaleUpAnimation(viewSharedElement,
                    viewSharedElement.width / 2,
                    viewSharedElement.height / 2,
                    0, 0)
                    .toBundle()
            2 -> return ActivityOptionsCompat.makeThumbnailScaleUpAnimation(viewSharedElement,
                    bitmap!!,
                    0, 0)
                    .toBundle()
            3 -> return ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                    viewSharedElement,
                    getString(R.string.activity_shared_element))
                    .toBundle()
            4 -> return ActivityOptionsCompat.makeClipRevealAnimation(viewSharedElement,
                    viewSharedElement.width / 2,
                    viewSharedElement.height / 2,
                    0, 0)
                    .toBundle()
            else -> return null
        }
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, ActivityActivity::class.java)
            context.startActivity(starter)
        }
    }
}
