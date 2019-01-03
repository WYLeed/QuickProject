package com.bsfy.superweightmodel.feature.blur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bsfy.superutilsmodel.util.Utils;


/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2018/12/13
 *     desc  :
 * </pre>
 */
public class TransparentActivity extends Activity {

    public static void start() {
        Intent starter = new Intent(Utils.getApp(), TransparentActivity.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Utils.getApp().startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
