package com.bsfy.superweightmodel;

import android.os.Environment;


import com.bsfy.superutilsmodel.util.Utils;

import java.io.File;

/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2017/05/10
 *     desc  : config about constants
 * </pre>
 */
public class Config {

    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String LINE_SEP = System.getProperty("line.separator");
    public static final String PKG      = "com.BSFY.androidutilcode";
    public static final String TEST_PKG = "com.BSFY.testinstall";
    public static final String GITHUB   = "https://github.com/BSFY/AndroidUtilCode";
    public static final String BLOG     = "https://BSFY.com";
    public static final String CACHE_PATH;
    public static final String TEST_APK_PATH;

    static {
        File cacheDir = Utils.getApp().getExternalCacheDir();
        if (cacheDir != null) {
            CACHE_PATH = cacheDir.getAbsolutePath();
        } else {
            CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        TEST_APK_PATH = CACHE_PATH + FILE_SEP + "test_install.apk";
    }
}
