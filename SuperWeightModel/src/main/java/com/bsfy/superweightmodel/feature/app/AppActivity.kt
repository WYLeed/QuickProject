package com.bsfy.superweightmodel.feature.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bsfy.superutilsmodel.util.*
import com.bsfy.superweightmodel.Config
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.helper.PermissionHelper


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/10/13
 * desc  : demo about AppUtils
</pre> *
 */

class AppActivity : BaseBackActivity() {

    private val listener = OnReleasedListener { AppUtils.installApp(Config.TEST_APK_PATH) }

    override fun initData(bundle: Bundle?) {
        AppUtils.registerAppStatusChangedListener(this, object : Utils.OnAppStatusChangedListener {
            override fun onForeground() {
                ToastUtils.showShort("foreground")
            }

            override fun onBackground() {
                ToastUtils.showShort("background")
            }
        })
    }

    override fun bindLayout(): Int {
        return R.layout.activity_app
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        setTitle(R.string.demo_app)

        findViewById<View>(R.id.btn_install_app).setOnClickListener(this)
        findViewById<View>(R.id.btn_install_app_silent).setOnClickListener(this)
        findViewById<View>(R.id.btn_uninstall_app).setOnClickListener(this)
        findViewById<View>(R.id.btn_uninstall_app_silent).setOnClickListener(this)
        findViewById<View>(R.id.btn_launch_app).setOnClickListener(this)
        findViewById<View>(R.id.btn_relaunch_app).setOnClickListener(this)
        findViewById<View>(R.id.btn_exit_app).setOnClickListener(this)
        findViewById<View>(R.id.btn_launch_app_details_settings).setOnClickListener(this)
        val tvAboutApp = findViewById<TextView>(R.id.tv_about_app)
        tvAboutApp.text = SpanUtils()
                .appendLine("isAppRoot: " + AppUtils.isAppRoot())
                .appendLine("isAppDebug: " + AppUtils.isAppDebug())
                .appendLine("isAppSystem: " + AppUtils.isAppSystem())
                .appendLine("isAppForeground: " + AppUtils.isAppForeground())
                .append("getAppIcon: ").appendImage(AppUtils.getAppIcon(), SpanUtils.ALIGN_CENTER)
                .appendLine()
                .appendLine("getAppPackageName: " + AppUtils.getAppPackageName())
                .appendLine("getAppName: " + AppUtils.getAppName())
                .appendLine("getAppPath: " + AppUtils.getAppPath())
                .appendLine("getAppVersionName: " + AppUtils.getAppVersionName())
                .appendLine("getAppVersionCode: " + AppUtils.getAppVersionCode())
                .appendLine("getAppSignatureSHA1: " + AppUtils.getAppSignatureSHA1())
                .appendLine("getAppSignatureSHA256: " + AppUtils.getAppSignatureSHA256())
                .append("getAppSignatureMD5: " + AppUtils.getAppSignatureMD5())
                .create()
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_install_app) {
            if (AppUtils.isAppInstalled(Config.TEST_PKG)) {
                ToastUtils.showShort(R.string.app_install_tips)
            } else {
                PermissionHelper.requestStorage {
                    if (!FileUtils.isFileExists(Config.TEST_APK_PATH)) {
                        ReleaseInstallApkTask(listener).execute()
                    } else {
                        listener.onReleased()
                        LogUtils.d("test apk existed.")
                    }
                }
            }

        } else if (i == R.id.btn_install_app_silent) {
            if (AppUtils.isAppInstalled(Config.TEST_PKG)) {
                ToastUtils.showShort(R.string.app_install_tips)
            } else {
                if (AppUtils.installAppSilent(Config.TEST_APK_PATH)) {
                    ToastUtils.showShort(R.string.install_successfully)
                } else {
                    ToastUtils.showShort(R.string.install_unsuccessfully)
                }
            }

        } else if (i == R.id.btn_uninstall_app) {
            if (AppUtils.isAppInstalled(Config.TEST_PKG)) {
                AppUtils.uninstallApp(Config.TEST_PKG)
            } else {
                ToastUtils.showShort(R.string.app_uninstall_tips)
            }

        } else if (i == R.id.btn_uninstall_app_silent) {
            if (AppUtils.isAppInstalled(Config.TEST_PKG)) {
                if (AppUtils.uninstallAppSilent(Config.TEST_PKG, false)) {
                    ToastUtils.showShort(R.string.uninstall_successfully)
                } else {
                    ToastUtils.showShort(R.string.uninstall_unsuccessfully)
                }
            } else {
                ToastUtils.showShort(R.string.app_uninstall_tips)
            }

        } else if (i == R.id.btn_launch_app) {
            AppUtils.launchApp(this.packageName)

        } else if (i == R.id.btn_relaunch_app) {
            AppUtils.relaunchApp()

        } else if (i == R.id.btn_launch_app_details_settings) {
            AppUtils.launchAppDetailsSettings()

        } else if (i == R.id.btn_exit_app) {
            AppUtils.exitApp()

        }
    }

    override fun onDestroy() {
        AppUtils.unregisterAppStatusChangedListener(this)
        super.onDestroy()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, AppActivity::class.java)
            context.startActivity(starter)
        }
    }
}
