package com.bsfy.superweightmodel.feature.permission

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.constant.PermissionConstants
import com.bsfy.superutilsmodel.util.LogUtils
import com.bsfy.superutilsmodel.util.PermissionUtils
import com.bsfy.superutilsmodel.util.ScreenUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.helper.DialogHelper

/**
 * <pre>
 * author: BSFY
 *
 * time  : 2018/01/01
 * desc  : demo about PermissionUtils
</pre> *
 */
class PermissionActivity : BaseBackActivity() {

    internal lateinit var tvAboutPermission: TextView
    internal lateinit var permissions: String

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_permission
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_permission)

        tvAboutPermission = findViewById(R.id.tv_about_permission)
        findViewById<View>(R.id.btn_open_app_settings).setOnClickListener(this)
        findViewById<View>(R.id.btn_request_calendar).setOnClickListener(this)
        findViewById<View>(R.id.btn_request_record_audio).setOnClickListener(this)
        findViewById<View>(R.id.btn_request_calendar_and_record_audio).setOnClickListener(this)

        val sb = StringBuilder()
        for (s in PermissionUtils.getPermissions()) {
            sb.append(s.substring(s.lastIndexOf('.') + 1)).append("\n")
        }
        permissions = sb.toString()
    }

    override fun onResume() {
        super.onResume()
        updateAboutPermission()
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_open_app_settings) {
            PermissionUtils.launchAppDetailsSettings()

        } else if (i == R.id.btn_request_calendar) {
            PermissionUtils.permission(PermissionConstants.CALENDAR)
                    .rationale { shouldRequest -> DialogHelper.showRationaleDialog(shouldRequest) }
                    .callback(object : PermissionUtils.FullCallback {
                        override fun onGranted(permissionsGranted: List<String>) {
                            updateAboutPermission()
                            LogUtils.d(permissionsGranted)
                        }

                        override fun onDenied(permissionsDeniedForever: List<String>,
                                              permissionsDenied: List<String>) {
                            if (!permissionsDeniedForever.isEmpty()) {
                                DialogHelper.showOpenAppSettingDialog()
                            }
                            LogUtils.d(permissionsDeniedForever, permissionsDenied)
                        }
                    })
                    .theme { activity -> ScreenUtils.setFullScreen(activity) }
                    .request()

        } else if (i == R.id.btn_request_record_audio) {
            PermissionUtils.permission(PermissionConstants.MICROPHONE)
                    .rationale { shouldRequest -> DialogHelper.showRationaleDialog(shouldRequest) }
                    .callback(object : PermissionUtils.FullCallback {
                        override fun onGranted(permissionsGranted: List<String>) {
                            updateAboutPermission()
                            LogUtils.d(permissionsGranted)
                        }

                        override fun onDenied(permissionsDeniedForever: List<String>,
                                              permissionsDenied: List<String>) {
                            if (!permissionsDeniedForever.isEmpty()) {
                                DialogHelper.showOpenAppSettingDialog()
                            }
                            LogUtils.d(permissionsDeniedForever, permissionsDenied)
                        }
                    })
                    .request()

        } else if (i == R.id.btn_request_calendar_and_record_audio) {
            PermissionUtils.permission(PermissionConstants.CALENDAR, PermissionConstants.MICROPHONE)
                    .rationale { shouldRequest -> DialogHelper.showRationaleDialog(shouldRequest) }
                    .callback(object : PermissionUtils.FullCallback {
                        override fun onGranted(permissionsGranted: List<String>) {
                            updateAboutPermission()
                            LogUtils.d(permissionsGranted)
                        }

                        override fun onDenied(permissionsDeniedForever: List<String>,
                                              permissionsDenied: List<String>) {
                            if (!permissionsDeniedForever.isEmpty()) {
                                DialogHelper.showOpenAppSettingDialog()
                            }
                            LogUtils.d(permissionsDeniedForever, permissionsDenied)
                        }
                    })
                    .request()

        }
    }

    private fun updateAboutPermission() {
        tvAboutPermission.text = SpanUtils()
                .append(permissions).setBold()
                .appendLine("READ_CALENDAR: " + PermissionUtils.isGranted(Manifest.permission.READ_CALENDAR))
                .appendLine("RECORD_AUDIO: " + PermissionUtils.isGranted(Manifest.permission.RECORD_AUDIO))
                .create()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, PermissionActivity::class.java)
            context.startActivity(starter)
        }
    }
}
