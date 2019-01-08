package com.bsfy.superweightmodel

import android.content.pm.PackageManager
import android.util.Log
import com.bsfy.superutilsmodel.util.Utils
import com.github.moduth.blockcanary.BlockCanaryContext
import com.github.moduth.blockcanary.BuildConfig

/**
 * 作者: Created by wangyu on 2019/1/8.
 * 卡顿监测器
 */

class AppBlockCanaryContext : BlockCanaryContext() {

    override fun provideQualifier(): String {
        var qualifier = ""
        try {
            val info = Utils.getApp().packageManager
                    .getPackageInfo(Utils.getApp().packageName, 0)
            qualifier += info.versionCode.toString() + "_" + info.versionName + "_YYB"
        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(TAG, "provideQualifier exception", e)
        }
        return qualifier
    }

    override fun provideBlockThreshold(): Int {
        return 500
    }

    override fun displayNotification(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun stopWhenDebugging(): Boolean {
        return false
    }

    companion object {
        private val TAG = "AppContext"
    }
}
