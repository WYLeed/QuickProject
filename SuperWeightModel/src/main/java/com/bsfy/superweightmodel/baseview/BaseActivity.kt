package com.bsfy.superweightmodel.baseview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.bsfy.superutilsmodel.constant.PermissionConstants
import com.bsfy.superutilsmodel.util.AntiShakeUtils
import com.bsfy.superutilsmodel.util.LogUtils
import com.bsfy.superutilsmodel.util.PermissionUtils
import com.bsfy.superweightmodel.helper.DialogHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.yokeyword.fragmentation.SupportActivity


/**
 * ```
 * author: BSFY
 * blog  : com.bsfy.httpmode
 * time  : 2018/11/16
 * desc  : base about activity
 * ```
 */
abstract class BaseActivity : SupportActivity(), IBaseView {

    private lateinit var mContentView: View
    private lateinit var mActivity: Activity

    var mCompositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mActivity = this
        super.onCreate(savedInstanceState)
        getRequestPermissions()
        initData(intent.extras)
        mCompositeDisposable = CompositeDisposable()
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


    /**
     * 添加订阅
     */
    fun addDisposable(mDisposable: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(mDisposable)
    }

    /**
     * 取消所有订阅
     */
    private fun clearDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDisposable()
    }

}