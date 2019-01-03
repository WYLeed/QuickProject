package com.bsfy.superweightmodel.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import com.bsfy.superutilsmodel.constant.PermissionConstants
import com.bsfy.superutilsmodel.util.AntiShakeUtils
import com.bsfy.superutilsmodel.util.LogUtils
import com.bsfy.superutilsmodel.util.PermissionUtils
import com.bsfy.superweightmodel.helper.DialogHelper

/**
 * ```
 * author: BSFY
 * blog  : http://BSFY.com
 * time  : 2018/11/16
 * desc  : base about activity
 * ```
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {

    private lateinit var mContentView: View
    private lateinit var mActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        mActivity = this
        super.onCreate(savedInstanceState)
        getRequestPermissions()
        initData(intent.extras)
        setRootLayout(bindLayout())
        initView(savedInstanceState, mContentView)
        doBusiness()
    }

    private fun getRequestPermissions() {
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .rationale { shouldRequest -> DialogHelper.showRationaleDialog(shouldRequest) }
                .callback(object : PermissionUtils.FullCallback {
                    override fun onGranted(permissionsGranted: List<String>) {
                        LogUtils.d(permissionsGranted)
                    }

                    override fun onDenied(permissionsDeniedForever: List<String>, permissionsDenied: List<String>) {
                        if (!permissionsDeniedForever.isEmpty()) {
                            DialogHelper.showOpenAppSettingDialog()
                        }
                        LogUtils.d(permissionsDeniedForever, permissionsDenied)
                    }
                })
                .request()
    }

    override fun setRootLayout(layoutId: Int) {
        if (layoutId <= 0) return
        mContentView = LayoutInflater.from(this).inflate(layoutId, null)
        setContentView(mContentView)
    }

    override fun onClick(view: View) {
        if (AntiShakeUtils.isValid(view, 200)) {
            onWidgetClick(view)
        }
    }


}