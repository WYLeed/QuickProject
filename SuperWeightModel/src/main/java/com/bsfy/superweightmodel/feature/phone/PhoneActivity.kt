package com.bsfy.superweightmodel.feature.phone

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.util.PhoneUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.helper.PermissionHelper

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/13
 * desc  : demo about PhoneUtils
</pre> *
 */
class PhoneActivity : BaseBackActivity() {

    private var tvAboutPhone: TextView? = null

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_phone
    }

    @SuppressLint("MissingPermission")
    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_phone)

        findViewById<View>(R.id.btn_dial).setOnClickListener(this)
        findViewById<View>(R.id.btn_call).setOnClickListener(this)
        findViewById<View>(R.id.btn_send_sms).setOnClickListener(this)
        findViewById<View>(R.id.btn_send_sms_silent).setOnClickListener(this)
        tvAboutPhone = findViewById(R.id.tv_about_phone)

        PermissionHelper.requestPhone(
                {
                    tvAboutPhone!!.text = SpanUtils()
                            .appendLine("isPhone: " + PhoneUtils.isPhone())
                            .appendLine("getDeviceId: " + PhoneUtils.getDeviceId())
                            .appendLine("getIMEI: " + PhoneUtils.getIMEI())
                            .appendLine("getMEID: " + PhoneUtils.getMEID())
                            .appendLine("getIMSI: " + PhoneUtils.getIMSI())
                            .appendLine("getPhoneType: " + PhoneUtils.getPhoneType())
                            .appendLine("isSimCardReady: " + PhoneUtils.isSimCardReady())
                            .appendLine("getSimOperatorName: " + PhoneUtils.getSimOperatorName())
                            .appendLine("getSimOperatorByMnc: " + PhoneUtils.getSimOperatorByMnc())
                            .appendLine("getPhoneStatus: " + PhoneUtils.getPhoneStatus())
                            .create()
                }
        ) {
            tvAboutPhone!!.text = SpanUtils()
                    .appendLine("isPhone: " + PhoneUtils.isPhone())
                    .appendLine("getDeviceId: " + "need permission")
                    .appendLine("getIMEI: " + "need permission")
                    .appendLine("getMEID: " + "need permission")
                    .appendLine("getIMSI: " + "need permission")
                    .appendLine("getPhoneType: " + PhoneUtils.getPhoneType())
                    .appendLine("isSimCardReady: " + PhoneUtils.isSimCardReady())
                    .appendLine("getSimOperatorName: " + PhoneUtils.getSimOperatorName())
                    .appendLine("getSimOperatorByMnc: " + PhoneUtils.getSimOperatorByMnc())
                    .appendLine("getPhoneStatus: " + "need permission")
                    .create()
        }
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_dial) {
            PhoneUtils.dial("10000")

        } else if (i == R.id.btn_call) {
            PermissionHelper.requestPhone { PhoneUtils.call("10000") }

        } else if (i == R.id.btn_send_sms) {
            PhoneUtils.sendSms("10000", "sendSms")

        } else if (i == R.id.btn_send_sms_silent) {
            PermissionHelper.requestSms { PhoneUtils.sendSmsSilent("10000", "sendSmsSilent") }

        }
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, PhoneActivity::class.java)
            context.startActivity(starter)
        }
    }
}
