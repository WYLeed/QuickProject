package com.bsfy.quickmodel;

import android.Manifest;
import android.app.Activity;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * @author wangyu
 * @date 2019/1/24
 */

public class PermissionsUtils {

    /**
     * 本地插件包权限申请
     *
     * @param activity
     * @param callBack
     */
    public static void verifyStoragePermissions(Activity activity, NormalCallBack<Boolean> callBack) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    Toast.makeText(activity, "同意权限", Toast.LENGTH_SHORT).show();
                    if (callBack != null) {
                        callBack.onCallBack(true);
                    }
                } else {
                    Toast.makeText(activity, "拒绝权限", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
