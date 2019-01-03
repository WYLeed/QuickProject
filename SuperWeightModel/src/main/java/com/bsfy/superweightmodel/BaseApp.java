package com.bsfy.superweightmodel;

import android.content.Context;

import com.bsfy.superutilsmodel.util.Utils;
import com.bsfy.superweightmodel.base.BaseApplication;


/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2016/10/12
 *     desc  : app about utils
 * </pre>
 */
public class BaseApp extends BaseApplication {

    private static BaseApp sInstance;

    public static BaseApp getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        Utils.init(this);
        super.onCreate();
        sInstance = this;
    }
}


