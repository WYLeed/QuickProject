package com.bsfy.superbluemodel.utils;

import android.os.Build;

/**
 * Created by bsfy on 2016/11/2.
 */

public class Version {

    public static boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
